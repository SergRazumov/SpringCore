package ru.alishev.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Objects;

@Component
public class PostProxyInvokerContextListener implements ApplicationListener<ContextRefreshedEvent> {
    @Autowired
    private ConfigurableListableBeanFactory factory; // не ApplicationContext потому что могут быть синглтон Lazy, а так же
    // хранится инфа не о проксированном классе
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        ApplicationContext context = event.getApplicationContext();
        System.out.println(factory.getBeanDefinition("jazzMusic"));
        for (String nameBean : context.getBeanDefinitionNames()) {
            if (nameBean.equals("jazzMusic")) {
                System.out.println("ApplicationContext: NameBean " + nameBean + " With class " + context.getBean(nameBean).getClass());
            }
        }
    }
}
