package ru.alishev.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.alishev.model.ClassicalMusic;
import ru.alishev.model.Music;

@Configuration
public class MySpringConfig extends Config {

    @Bean
    public Music myClassicalMusic() {
        return classicalMusic();
    }

}
