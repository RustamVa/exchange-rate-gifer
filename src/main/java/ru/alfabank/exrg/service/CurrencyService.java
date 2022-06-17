package ru.alfabank.exrg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.alfabank.exrg.client.OERClient;
import ru.alfabank.exrg.dto.CurrencyDTO;

@Service
public class CurrencyService {
    private final OERClient oerClient;
    @Value("${OER.app_id}")
    private String apiId;

    @Autowired
    public CurrencyService(OERClient oerClient) {
        this.oerClient = oerClient;
    }

    public CurrencyDTO getCurrencies() {
        return oerClient.getCurrency(apiId);
    }
}
