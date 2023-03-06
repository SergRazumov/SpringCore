package ru.alishev.model;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Component
public class ProfilingHandlerBeanPostProcessor extends CustomBeanPostProcessor implements BeanPostProcessor {
    @Autowired
    private ApplicationContext context;

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Field[] fields = bean.getClass().getDeclaredFields();
        Arrays.stream(fields).forEach(field -> {
            try {
                InjectRandomInt annotation = field.getAnnotation(InjectRandomInt.class);
                if (annotation != null) {
                    int min = annotation.min();
                    int max = annotation.max();
                    max -= min;
                    int num = (int) (Math.random() * ++max) + min;
                    field.setAccessible(true); // устанавливаем в private поле значение т.к private делаем доступ
                    ReflectionUtils.setField(field, bean, num);
                    System.out.println("Phase 1 volume after postProcessBeforeInitialization this class field = " + num);
                } else if (field.getName().equals("switchMusicPlayer")) {
                    field.setAccessible(true);
                    System.out.println("Phase 1 postProcessBeforeInitialization already autowired ? " + field.get(context.getBean(MusicPlayer.class)));
                } else if (field.getName().equals("name")) {
                    field.setAccessible(true);
                    System.out.println("Phase 1 postProcessBeforeInitialization already property variable ? " + field.get(bean));
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        });
        Class<?> beanClass = bean.getClass();
        if (beanClass.isAnnotationPresent(Profiling.class)) {
            map.put(beanName, beanClass);
            System.out.println("Phase 1 after postProcessBeforeInitialization annotation up class ");
            System.out.println("-----------------Закончилась фаза postProcessBeforeInitialization для JazzMusic---------------------\n");
        }
        for (Method method : beanClass.getDeclaredMethods()) {
            if (method.isAnnotationPresent(PostProxy.class)) {
                System.out.println("Phase 1 PostProxy annotation up method");
                System.out.println("-----------------Закончилась фаза postProcessBeforeInitialization для MusicPlayer---------------------\n");
            }
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Field[] fields = bean.getClass().getDeclaredFields();
        Arrays.stream(fields).forEach(field -> {
            InjectRandomInt annotation = field.getAnnotation(InjectRandomInt.class);
            if (annotation != null) {
                int min = annotation.min();
                int max = annotation.max();
                max -= min;
                int num = (int) (Math.random() * ++max) + min;
                field.setAccessible(true); // устанавливаем в private поле значение т.к private делаем доступ
                ReflectionUtils.setField(field, bean, num);
                System.out.println("Phase 3 volume after postProcessAfterInitialization this class field = " + num);
            }
        });
        Class<?> newbeanClass = bean.getClass();
        for (Method method : newbeanClass.getDeclaredMethods()) {
            if (method.isAnnotationPresent(PostProxy.class)) {
                System.out.println("Phase 3 PostProxy annotation up method");
                System.out.println("-----------------Закончилась фаза postProcessAfterInitialization для MusicPlayer---------------------\n");
            }
        }
        Class<?> beanClass = map.get(beanName);
        if (beanClass != null && beanClass.isAnnotationPresent(Profiling.class)) {
            map.put(beanName, ClassicalMusic.class);
            System.out.println("Phase 3 after postProcessAfterInitialization");
            //Метод генерит объект из нового класса который сгенерит сам же на лету, принимает класс loader при помощи которого
            //класс загрузится в heap, второй параметр список интерфейсов которые имплементит сгенеренный класс,
            return new ClassicalMusic();
        }
        return bean;
    }
}
