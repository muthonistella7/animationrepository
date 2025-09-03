package com.biblecartoon;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.HashMap;
import java.util.Map;

@Service
public class AnimationService {

    @Value("${mochi1.api.key}")
    private String mochiApiKey;

    @Value("${mochi1.api.url}")
    private String mochiApiUrl;

    private final RestTemplate restTemplate = new RestTemplate();

    public Animation generateFromVerse(String verse) {
        // Prepare request body
        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("text", verse);
        requestBody.put("style", "cartoon");

        // Prepare headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + mochiApiKey);

        HttpEntity<Map<String, String>> entity = new HttpEntity<>(requestBody, headers);

        // Send request to Mochi 1 API
        ResponseEntity<Map> response = restTemplate.postForEntity(mochiApiUrl, entity, Map.class);

        String videoUrl = "";
        if (response.getStatusCode() == HttpStatus.OK && response.getBody() != null) {
            videoUrl = (String) response.getBody().getOrDefault("video_url", "");
        }

        Animation animation = new Animation();
        animation.setVerse(verse);
        animation.setScript("Cartoon animation for: " + verse);
        animation.setAnimationUrl(videoUrl);
        return animation;
    }
}
