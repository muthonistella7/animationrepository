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
    @Autowired
    private AnimationService animationService;
    @GetMapping("/")
    public String home() {
        return "Bible Cartoon Animation API";
    }

    @PostMapping("/generate")
    public Animation generateAnimation(@RequestParam("verse") String verse) {
        // Use AnimationService to generate video
        Animation animation = animationService.generateFromVerse(verse);
        animationRepository.save(animation);
        return animation;
    }
}
