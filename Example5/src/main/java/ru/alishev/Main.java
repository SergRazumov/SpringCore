package ru.alishev;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.alishev.config.SpringConfig;
import ru.alishev.model.MusicPlayer;

public class Main {
    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                SpringConfig.class)) {

            MusicPlayer player = context.getBean(MusicPlayer.class);
            player.playMusic();
        }

    }
}
