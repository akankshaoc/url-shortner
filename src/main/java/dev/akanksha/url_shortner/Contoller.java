package dev.akanksha.url_shortner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Map;

@RestController
public class Contoller {

    @Autowired
    Services services;

    @PostMapping("shorten")
    public ResponseEntity<String> shorten(@RequestBody Map<String, String> body) {
        return new ResponseEntity<>(services.shorten(body.get("url")), HttpStatus.CREATED);
    }

    @GetMapping("redirect/{shortUrl}")
    public RedirectView redirect(@PathVariable String shortUrl) {
        return new RedirectView(services.getUrl(shortUrl));
    }
}
