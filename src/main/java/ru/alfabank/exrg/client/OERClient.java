package ru.alfabank.exrg.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import ru.alfabank.exrg.model.Currency;

@FeignClient(name = "OERClient", url = "${OER.url}")
public interface OERClient {
    @GetMapping("/latest.json")
    Currency getCurrency(@RequestParam("app_id") String appId);

    @GetMapping("/historical/{date}.json")
    Currency getCurrency(@PathVariable String date, @RequestParam("app_id") String appId);
}
