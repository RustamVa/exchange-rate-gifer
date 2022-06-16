package ru.alfabank.exrg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.alfabank.exrg.dto.GifDTO;
import ru.alfabank.exrg.service.GifService;

@RestController
@RequestMapping("/api/gif")
public class MainController {

    private final GifService gifService;
    @Autowired
    public MainController(GifService gifService) {
        this.gifService = gifService;
    }

    @GetMapping("/{tag}")
    public ResponseEntity<GifDTO> getGif(@PathVariable String tag) {
        return gifService.getGif(tag);
    }
}
