package ru.alishev.happy;

import javafx.util.Pair;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

import static java.time.LocalTime.now;

public class PeriodicalScopeConfigure implements Scope {

    Map<String, Pair<LocalTime, Object>> map = new HashMap<>();


    //ObjectFactory какой то beanDefinition
    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {
        if(map.containsKey(name)) {
            Pair<LocalTime, Object> pair = map.get(name);
            int secondSinceLastRequest = now().getSecond() - pair.getKey().getSecond();
            if(secondSinceLastRequest>5) {
                map.put(name, new Pair<>(now(), objectFactory.getObject()));
            }

        } else {
            map.put(name, new Pair<>(now(), objectFactory.getObject()));
        }
        return map.get(name).getValue();
    }

    @Override
    public Object remove(String name) {
        return null;
    }

    @Override
    public void registerDestructionCallback(String name, Runnable callback) {

    }

    @Override
    public Object resolveContextualObject(String key) {
        return null;
    }

    @Override
    public String getConversationId() {
        return null;
    }
}
