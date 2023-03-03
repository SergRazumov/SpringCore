package ru.alishev.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.alishev.model.Music;
import ru.alishev.model.RockMusic;


@Configuration
public class MySpringConfig {
    @Bean
    public Music myRockMusic() {
        return new RockMusic();
    }


    @Bean
    public boolean switchMusic() {return true;}
}
