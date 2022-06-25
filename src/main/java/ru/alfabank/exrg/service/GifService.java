package ru.alfabank.exrg.service;

import org.springframework.http.ResponseEntity;
import ru.alfabank.exrg.model.Gif;

public interface GifService {
    ResponseEntity<Gif> getGif(String tag);
}
