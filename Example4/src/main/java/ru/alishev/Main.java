package ru.alishev;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.alishev.config.SpringConfig;
import ru.alishev.model.MusicPlayer;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(
                SpringConfig.class);

        MusicPlayer player1 = context.getBean(MusicPlayer.class);
        MusicPlayer player2 = context.getBean(MusicPlayer.class);
        System.out.println(player1 == player2);
        player2.setVolume(70);
        player1.playMusic();
        player2.playMusic();
    }
}
