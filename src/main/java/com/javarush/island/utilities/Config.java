package com.javarush.island.utilities;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) // Для чтении инофрмации при помощи рефлекции во время выполнения
@Target(ElementType.TYPE) // Применяем только к классам
public @interface Config {
    String fileName() default "";
}
