package com.javarush.island.utilities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Settings {

    public static final String SALUTATION = "Приветствую тебя, мой дорогой друг!" +
            "Приступаем к созданию острова!";
    public static final String CREATE_MAP = "Введите размер карты.";
    public static final String INPUT_ROWS = "Введите длину острова: ";
    public static final String INPUT_COLS = "Введите ширину острова: ";
    public static final String NOT_KNOW_ERROR = "Упс! Что-то пошло не так";
    public static int ROWS;
    public static int COLS;

}
