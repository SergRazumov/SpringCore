package ru.alishev.model;

import org.springframework.context.SmartLifecycle;

import javax.annotation.PreDestroy;

public class ClassicalMusic implements Music, SmartLifecycle {

    private boolean running;
    public ClassicalMusic() {
        System.out.println("Start1 -> Constructor ClassicalMusic");
    }

    @Override
    public String getSong() {
        return "Nugarian Rhapsody";
    }

    @PreDestroy
    private void destroy() {
        System.out.println("Start2 -> Destroy ClassicalMusic");
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
        return Integer.MAX_VALUE;
    }
}
