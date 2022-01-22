package com.dylan_park.wordie.game.web.config;

import com.dylan_park.wordie.data.Dictionary;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebGameConfig {
    public String path = "src/main/resources/dictionary.txt";

    @Bean(name = "dictionary")
    public Dictionary dictionary() {
        return new Dictionary(path);
    }
}
