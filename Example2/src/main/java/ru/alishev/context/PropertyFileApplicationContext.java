package ru.alishev.context;

import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;
import org.springframework.context.support.GenericApplicationContext;
import ru.alishev.model.ClassicalMusic;

public class PropertyFileApplicationContext extends GenericApplicationContext {

    public PropertyFileApplicationContext(String fileName) {
        PropertiesBeanDefinitionReader reader = new PropertiesBeanDefinitionReader(this);
        int i = reader.loadBeanDefinitions(fileName);
        System.out.println("found " + i + " beans");
        refresh();

    }

    public static void main(String[] args) {
        PropertyFileApplicationContext context = new PropertyFileApplicationContext("context.properties");
        System.out.println(context.getBean(ClassicalMusic.class).getSong());
    }
}
