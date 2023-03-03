package ru.alishev.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.alishev.model.ClassicalMusic;
import ru.alishev.model.Music;
public class Config {
    @Bean
    public Music classicalMusic() {
        return new ClassicalMusic();
    }
}
