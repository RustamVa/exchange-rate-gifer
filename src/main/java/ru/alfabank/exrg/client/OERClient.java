package ru.alfabank.exrg.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.alfabank.exrg.dto.CurrencyDTO;

@FeignClient(name = "OERClient", url = "${OER.url}")
public interface OERClient {
    @GetMapping("/latest.json")
    CurrencyDTO getCurrency(@RequestParam("app_id") String appId);
}
