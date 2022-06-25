package ru.alfabank.exrg.service.impls;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.alfabank.exrg.client.OERClient;
import ru.alfabank.exrg.model.Currency;
import ru.alfabank.exrg.service.CurrencyService;
import ru.alfabank.exrg.util.Result;


import java.text.SimpleDateFormat;
import java.util.*;

@Service
@Slf4j
public class CurrencyServiceImpl implements CurrencyService {
    private static final String PATTERN = "yyyy-MM-dd";
    private static final int TIMESTAMP_ERROR = 1000;
    private final OERClient oerClient;
    private Currency currentCurrency;
    private Currency prevCurrency;

    @Value("${OER.app_id}")
    private String apiId;

    @Autowired
    public CurrencyServiceImpl(OERClient oerClient) {
        this.oerClient = oerClient;
    }

    @Override
    public Set<String> getCodes() {
        log.info("Getting currencies codes.");
        Currency curr = oerClient.getCurrency(apiId);
        return curr.getRates().keySet();
    }

    @Override
    public Result getResult(String code) {
        log.info("Updating currencies.");
        this.updateCurrencies();
        Set<String> codes = this.getCodes();
        if (!codes.contains(code)) {
            log.error("Invalid currency code or code not found.");
            return  Result.ERROR;
        }
        Double currRate = this.currentCurrency.getRates().get(code);
        Double prevRate = this.prevCurrency.getRates().get(code);
        log.info("Current " + code + " to USD rate: " + currRate);
        log.info("Yesterday " + code + " rate: " + prevRate);
        return Double.compare(prevRate, currRate) == -1 ? Result.RICH : Result.BROKE;
    }

    private void updateCurrencies() {
        this.updateCurrentCurrency();
        this.updatePrevCurrency();

    }

    private void updateCurrentCurrency() {
        if (this.currentCurrency == null) {
            this.currentCurrency = oerClient.getCurrency(apiId);
        } else {
            if (this.needToUpdate(this.currentCurrency.getTimestamp())) {
                this.currentCurrency = oerClient.getCurrency(apiId);
            }
        }
    }


    private void updatePrevCurrency() {
        Currency currCurrency = this.currentCurrency;
        long currTimestamp = currCurrency.getTimestamp();
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(currTimestamp * 1000);

        if (this.prevCurrency == null) {
            this.prevCurrency = oerClient.getCurrency(getStrYesterday(calendar, -1), apiId);
            long prevTimestamp = this.prevCurrency.getTimestamp();
            if (Math.abs(prevTimestamp - currTimestamp) < TIMESTAMP_ERROR) {
                this.prevCurrency = oerClient.getCurrency(getStrYesterday(calendar, -2), apiId);
            }
        }
    }

    private boolean needToUpdate(long prev) {
        long curr = new Date().getTime();
        return (curr - prev) / (60 * 60 * 1000) >= 1;
    }


    private String getStrYesterday(Calendar calendar, int diff) {
        calendar.add(Calendar.DAY_OF_YEAR, diff);
        return new SimpleDateFormat(PATTERN).format(calendar.getTime());
    }



}
