package ru.alishev.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class MusicPlayer {
    private final Music music;
    @Value("${player-name}")
    private String name;
    @Setter
    @Getter
    @Value("${player-volume}")
    private int volume;

    public MusicPlayer(@Qualifier("rockMusic") Music music) {
        this.music = music;
    }

    public void playMusic() {
        System.out.format("Player %s is playing %s with %d volume%n", name, music.getSong(), volume);
    }
}
