package ru.alfabank.exrg.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.alfabank.exrg.dto.GifDTO;

@FeignClient(name = "giphyClient", url = "https://api.giphy.com/v1/gifs")
public interface GiphyClient {
    @GetMapping("/random")
    ResponseEntity<GifDTO> getRandomGif(@RequestParam("api_key") String apiKey,
                                @RequestParam("tag") String tag);

}
