package ru.alishev.config;

import org.springframework.context.annotation.*;
import ru.alishev.model.*;

@Configuration
public class SpringConfig extends Config{

   @Scope("prototype")
   @Bean
   public Music springClassicalMusicPrototype() {
       return classicalMusic();
   }

    @Bean
    public Music springClassicalMusic() {
        return classicalMusic();
    }

    @Bean(name = {"rockMusic", "RockMusic"})
    @Description("Текстовое описание бина RockMusic")
    public Music rockMusic() {
        return new RockMusic();
    }

    @Bean("jazzMusic")
    public Music myFavoriteMusic() {
        return new JazzMusic();
    }

    @Bean
    public MusicPlayer musicPlayer() {
        return new MusicPlayer(classicalMusic());
    }

    @Bean
    public MusicPlayer myMusicPlayer() {
        return new MusicPlayer(new ClassicalMusic());
    }
}
