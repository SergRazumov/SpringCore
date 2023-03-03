package ru.alishev.timeWork;

public class Time {
    public static void main(String[] args) {
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


    private static void badTime() {
        long before= System.nanoTime();
        Time time = createNewTime();
        long after = System.nanoTime();
        System.out.println(after-before);

    }


    private static Time createNewTime() {
        return new Time();
    }
}
