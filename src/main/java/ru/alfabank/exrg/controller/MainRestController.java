package ru.alfabank.exrg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.alfabank.exrg.model.Gif;
import ru.alfabank.exrg.service.impls.CurrencyServiceImpl;
import ru.alfabank.exrg.service.impls.GifServiceImpl;
import ru.alfabank.exrg.util.Result;

import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:63342")
@RequestMapping("/api/currency")
public class MainRestController {

    private  final GifServiceImpl gifService;
    private final CurrencyServiceImpl currencyService;
    @Autowired
    public MainRestController(GifServiceImpl gifService, CurrencyServiceImpl currencyService) {
        this.gifService = gifService;
        this.currencyService = currencyService;
    }


    @GetMapping("/codes")
    public ResponseEntity<List<String>> getCodes() {
        return  new ResponseEntity<>(currencyService.getCodes().stream().toList(),
                HttpStatus.OK);
    }


   @GetMapping("/check/{code}")
    public ResponseEntity<Gif> get(@PathVariable String code) {
        Result result = currencyService.getResult(code);
        return gifService.getGif(result.getValue());
   }

}
