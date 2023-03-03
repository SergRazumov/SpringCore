package ru.alishev.happy;

import org.springframework.context.annotation.*;

import java.awt.*;
import java.util.Random;

@Configuration
@ComponentScan(basePackages = "ru.alishev.happy")
public class Config{
    @Bean()
    //1 @Scope("prototype")
    //2!@Scope(value = "prototype" , proxyMode = ScopedProxyMode.TARGET_CLASS)
    //@Scope("prototype")
    @Scope("periodical")
    public Color color() {
        Random random = new Random();
       return new Color(random.nextInt(255) , random.nextInt(255), random.nextInt(255));
    }


    @Bean
    public ColorFrame frame() {
        return new ColorFrame() {
            @Override
            protected Color getColor() {
                return color();
            }
        };
    }

    public static void main(String[] args) throws InterruptedException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        while (true) {
            context.getBean("frame",ColorFrame.class).showOnRandomPlace();
            Thread.sleep(100);
        }
    }

}
