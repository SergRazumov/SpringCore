package ru.alishev;

import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.alishev.config.MySpringConfig;
import ru.alishev.config.SpringConfig;
import ru.alishev.model.*;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        Player player = context.getBean(Player.class);
        System.out.println("---------------------------------------------------------------------------\n");
            player.playMusic();
            myTest(context);
        context.close();
    }


    private static void myTest(ApplicationContext context) {
        Music myRockMusic = context.getBean("myRockMusic", Music.class);
        Music rockMusic = context.getBean("rockMusic", Music.class);
        System.out.println(myRockMusic == rockMusic);



        Music notJazzThisClassic = context.getBean("jazzMusic", Music.class);
        System.out.println(notJazzThisClassic.getSong());

//      Если на этапе создания map с Definition положить Class то и в IOC Container произойдет замена объекта
//       Player player = context.getBean("musicPlayer", NewMusicPlayer.class);
//       player.playMusic();
    }
}
