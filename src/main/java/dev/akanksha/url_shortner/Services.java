package dev.akanksha.url_shortner;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class Services {

    private static final Map<String, String> urlMap = new HashMap<>();
    int count = 0;

    public String shorten(String url) {
        String shortUrl = String.valueOf(++count);
        urlMap.put(shortUrl, url);
        return shortUrl;
    }

    public String getUrl(String shortUrl) {
        return urlMap.get(shortUrl);
    }
}
