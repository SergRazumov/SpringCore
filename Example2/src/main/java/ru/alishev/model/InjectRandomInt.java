package ru.alishev.model;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * Создаем свою аннотацию
 * RUNTIME означает, что есть везде и можно считать рефлексией
 * Source означает что данная аннотация видна только для source, не видно в байт коде
 * Class в байт код попадет, но нельзя будет считать через рефлексию, эта аннотация по умолчанию
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface InjectRandomInt {
    int min();
    int max();
}
