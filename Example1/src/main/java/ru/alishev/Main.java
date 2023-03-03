package ru.alishev;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.alishev.config.MySpringConfig;
import ru.alishev.config.SpringConfig;
import ru.alishev.model.ClassicalMusic;
import ru.alishev.model.Music;
import ru.alishev.model.MusicPlayer;
import ru.alishev.model.RockMusic;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(
                SpringConfig.class, MySpringConfig.class);

        Music musicRock = context.getBean("rockMusic", RockMusic.class);
        Music musicJazz = context.getBean("jazzMusic", Music.class);

        MusicPlayer rockPlayer = new MusicPlayer(musicRock);
        rockPlayer.playMusic();

        MusicPlayer jazzPlayer = new MusicPlayer(musicJazz);
        jazzPlayer.playMusic();

        MusicPlayer classicalPlayer = context.getBean("musicPlayer", MusicPlayer.class);
        classicalPlayer.playMusic();

        myTest(context);




    }


    private static void myTest(ApplicationContext context) {
        MusicPlayer classicalPlayer = context.getBean("musicPlayer", MusicPlayer.class);
        Music classicalMusic = context.getBean("springClassicalMusic", ClassicalMusic.class);
        System.out.println(classicalPlayer.getMusic() ==  classicalMusic);

        Music myClassicalMusic = context.getBean("myClassicalMusic", ClassicalMusic.class);
        System.out.println(myClassicalMusic == classicalMusic);


        MusicPlayer myMusicPlayer = context.getBean("myMusicPlayer", MusicPlayer.class);
        System.out.println(classicalPlayer.getMusic() == myMusicPlayer.getMusic());
    }
}
