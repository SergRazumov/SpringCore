package ru.alishev.happy;

import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.util.Random;

@Configuration
@ComponentScan(basePackages = "ru.alishev.happy")
public class Config{
    @Bean
    @Scope("prototype")
 //   @Scope(value = "periodical")
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
            context.getBean(ColorFrame.class).showOnRandomPlace();
            Thread.sleep(1000);
        }
    }

}
