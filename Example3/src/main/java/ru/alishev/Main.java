package ru.alishev;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import ru.alishev.config.SpringConfig;
import ru.alishev.model.MusicPlayer;
import ru.alishev.model.MyMusicPlayer;
public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(
                SpringConfig.class);

        MusicPlayer player = context.getBean(MusicPlayer.class);
        player.playMusic();
        MusicPlayer player1 = context.getBean(MusicPlayer.class);
        System.out.println(player == player1);


        myTest(context);
    }

    private static void myTest(ApplicationContext context) {
        MusicPlayer player = context.getBean(MusicPlayer.class);
        MyMusicPlayer myMusicPlayer = context.getBean(MyMusicPlayer.class);
        System.out.println(player.getMusic() == myMusicPlayer.getMusic());
    }
}
