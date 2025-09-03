package com.biblecartoon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class AnimationController {
    @Autowired
    private AnimationRepository animationRepository;
    @GetMapping("/")
    public String home() {
        return "Bible Cartoon Animation API";
    }

    @PostMapping("/generate")
    public Animation generateAnimation(@RequestParam("verse") String verse) {
        // Generate cartoon script from Bible verse
        String script = "Cartoon animation for: " + verse;
        String animationUrl = "/sample-animation.mp4";

        // Save to MongoDB
        Animation animation = new Animation();
        animation.setVerse(verse);
        animation.setScript(script);
        animation.setAnimationUrl(animationUrl);
        animationRepository.save(animation);

        return animation;
    }
}
