package ru.alishev.model;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Profiling
public class JazzMusic implements Music {

    public JazzMusic(){
        System.out.println("Constructor JazzMusic");
    }

    @Override
    public String getSong() {
        return "Down by the Riverside";
    }

    @PostConstruct
    private void init() {
        System.out.println("This Jazz Music its PostConstruct");
    }

    private void init2() {
        System.out.println("This Jazz Music its INIT");
        System.out.println("-----------------Закончилась фаза PostConstruct для JazzMusic---------------------\n");
    }

    @PreDestroy
    private void destroy() {
        System.out.println("JazzMusic destroy");
    }

    private void destroy2() {
        System.out.println("JazzMusic destroy2");
    }


}
