package ru.alishev.model;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

@Component
public class DeprecatedHandlerBeanFactory implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        String[] beans =  beanFactory.getBeanDefinitionNames();
        for(String str: beans) {
           BeanDefinition beanDefinition = beanFactory.getBeanDefinition(str);
           String beanClassName = beanDefinition.getBeanClassName();
            try {
                if(beanClassName!=null) {
                    Class<?> beanClass = Class.forName(beanClassName);
                    DeprecatedClass deprecatedClass = beanClass.getAnnotation(DeprecatedClass.class);
                    if(deprecatedClass!=null && deprecatedClass.switchAnnotation()) {
                        beanDefinition.setBeanClassName(deprecatedClass.newImpl().getName()); // в beanDefinition добавь еще 1 класс в случае если DeprecatedClass MusicPlayer из параметра
                    }
                }

            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("-----------------Закончилась фаза BeanFactoryPostProcessor -> postProcessBeanFactory---------------------\n");
    }
}
