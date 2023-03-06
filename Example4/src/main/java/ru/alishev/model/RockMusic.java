package ru.alishev.model;

import org.springframework.context.SmartLifecycle;

import javax.annotation.PreDestroy;

public class RockMusic implements Music, SmartLifecycle {

    private boolean running;

   public RockMusic() {
        System.out.println("Start2 -> Constructor RockMusic");
    }

    @Override
    public String getSong() {
        return "Bohemian Rhapsody (by Queen)";
    }

    @PreDestroy
    private void destroy() {
        System.out.println("Start1 -> Destroy RockMusic");
    }

    @Override
    public void start() {
        running = true;
    }

    @Override
    public void stop() {
        running = false;
    }

    @Override
    public boolean isRunning() {
        return running;
    }

    @Override
    public int getPhase() {
        return Integer.MIN_VALUE;
    }
}
