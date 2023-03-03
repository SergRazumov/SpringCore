package ru.alishev.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.annotation.PreDestroy;
@NoArgsConstructor
@Setter

public class ClassicalMusic implements Music {

    private String song;

    @Override
    public String getSong() {
        return song==null ? "Nugarian Rhapsody" : "Nugarian Rhapsody " + song;
    }

    @PreDestroy
    private void destroy() {
        System.out.println("I am prototype and do not close then context close");
    }
}
