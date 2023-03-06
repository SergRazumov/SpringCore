package ru.alishev.model;

import org.springframework.stereotype.Component;
import ru.alishev.config.MySpringConfig;


public class NewMusicPlayer  implements Player{

    public void playMusic() {
        System.out.println("Music from newMusicPlayer");
    }
}
