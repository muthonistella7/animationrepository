package com.biblecartoon;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "animations")
public class Animation {
    @Id
    private String id;
    private String verse;
    private String script;
    private String animationUrl;

    // Getters and setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getVerse() { return verse; }
    public void setVerse(String verse) { this.verse = verse; }
    public String getScript() { return script; }
    public void setScript(String script) { this.script = script; }
    public String getAnimationUrl() { return animationUrl; }
    public void setAnimationUrl(String animationUrl) { this.animationUrl = animationUrl; }
}
