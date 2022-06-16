package ru.alfabank.exrg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.alfabank.exrg.client.GiphyClient;
import ru.alfabank.exrg.dto.GifDTO;

@Service
public class GifService {

    private final GiphyClient giphyClient;
    @Value("${giphy.api_key}")
    private String apiKey;

    @Autowired
    public GifService(GiphyClient giphyClient) {
        this.giphyClient = giphyClient;

    }

    public ResponseEntity<GifDTO> getGif(String tag) {
        return giphyClient.getRandomGif(apiKey, tag);
    }
}
