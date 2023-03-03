package ru.alishev.model;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter()
public class MusicPlayer {
    private final Music music;
    @Value("${player-name}")
    private String name;
    @Value("${player-volume}")
    private int volume;

    @Autowired
    public MusicPlayer(@Qualifier("rockMusic") Music music, int volume) {
        this.music = music;
        this.volume = volume;
    }

    public MusicPlayer(@Qualifier("jazzMusic") Music music) {
        this.music = music;
    }

    public void playMusic() {
        System.out.format("Player %s is playing %s with %d volume%n", name, music.getSong(), volume);
    }
}
