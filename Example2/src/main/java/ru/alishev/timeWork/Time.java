package ru.alishev.timeWork;

import java.io.IOException;

/**
 * Класс времени
 */
public class Time {

    /* Test*/


    /**
     * Метод для входа
     * @param args массив String
     */
    public static void main(String[] args) throws IOException {
        long before = System.nanoTime();
        Time time = null;
        for(int i=0; i<1000000; i++) {
            time = createNewTime();
        }
        long after = System.nanoTime();
        System.out.println((after-before)/1000000);
        System.out.println(time);
        badTime();
    }


    private static void badTime() throws IOException {
        long before= System.nanoTime();
        Time time = createNewTime();
        long after = System.nanoTime();
        System.out.println(after-before);

    }

    /**
     * Создает объект
     * @return новый объект
     * @throws IOException ошибка при создании
     */
    private static Time createNewTime() throws IOException {
        return new Time();
    }
}
