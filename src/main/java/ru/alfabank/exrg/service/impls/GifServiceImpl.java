package ru.alfabank.exrg.service.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.alfabank.exrg.client.GiphyClient;
import ru.alfabank.exrg.model.Gif;
import ru.alfabank.exrg.service.GifService;

@Service
public class GifServiceImpl implements GifService {

    private final GiphyClient giphyClient;
    @Value("${giphy.api_key}")
    private String apiKey;

    @Autowired
    public GifServiceImpl(GiphyClient giphyClient) {
        this.giphyClient = giphyClient;

    }
    @Override
    public ResponseEntity<Gif> getGif(String tag)  {
        return giphyClient.getRandomGif(apiKey, tag);

    }
}
