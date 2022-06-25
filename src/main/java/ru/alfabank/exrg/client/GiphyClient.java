package ru.alfabank.exrg.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.alfabank.exrg.model.Gif;

@FeignClient(name = "giphyClient", url = "${giphy.url}")
public interface GiphyClient {
    @GetMapping("/random")
    ResponseEntity<Gif> getRandomGif(@RequestParam("api_key") String apiKey,
                                     @RequestParam("tag") String tag);

}
