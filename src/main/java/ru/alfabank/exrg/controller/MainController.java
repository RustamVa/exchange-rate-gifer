package ru.alfabank.exrg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.alfabank.exrg.dto.CurrencyDTO;
import ru.alfabank.exrg.dto.GifDTO;
import ru.alfabank.exrg.service.CurrencyService;
import ru.alfabank.exrg.service.GifService;

import java.util.Set;

@RestController
@RequestMapping("/api")
public class MainController {

    private final GifService gifService;
    private final CurrencyService currencyService;
    @Autowired
    public MainController(GifService gifService, CurrencyService currencyService) {
        this.gifService = gifService;
        this.currencyService = currencyService;
    }

    @GetMapping("/gif/{tag}")
    public ResponseEntity<GifDTO> getGif(@PathVariable String tag) {
        return gifService.getGif(tag);
    }

    @GetMapping("/curr")
    public CurrencyDTO getCurrencies() {
        return currencyService.getCurrencies();
    }
}
