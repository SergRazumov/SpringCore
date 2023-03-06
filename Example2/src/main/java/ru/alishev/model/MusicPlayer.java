package ru.alishev.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component("musicPlayer")
@DeprecatedClass(newImpl = NewMusicPlayer.class, switchAnnotation = false)
public class MusicPlayer implements Player {


    @InjectRandomInt(min=1, max=100)
    @Getter
    private int volume;
    @Value("${player-name}")
    private String name;
    private final Music music;
    @Autowired
    private boolean switchMusicPlayer;

    @Autowired
    public MusicPlayer(@Qualifier("rockMusic") Music music, int n) {

        this.music = music;
        System.out.println("Phase 0 MusicPlayer constructor customAnnotation " + volume); // Убеждаемся что тут значение 0 ибо поля при создании
        // бина еще пустые, для инициализации и использовании этого в конструкторе нужен метод init она же аннотация Post-Construct
        System.out.println("Phase 0 MusicPlayer constructor AutowiredAnnotation " + switchMusicPlayer);
        System.out.println("Phase 0 MusicPlayer constructor Property " + name);
        System.out.println("-----------------Закончилась фаза конструктора и базовой инициализации класса MusicPlayer---------------------\n");
    }




    @PostConstruct
    private void init() {
        System.out.println("Phase 2 volume after post-construct this init " + volume);
        System.out.println("-----------------Закончилась фаза PostConstruct для MusicPlayer---------------------\n");
    }
    @PostProxy
    private void postProxy() {

    }

    public void playMusic() {
        System.out.println("Playing " + music.getSong());
    }

    @PreDestroy
    private void destroy() {
        System.out.println("I am singleton and close then context close ");
    }
}
