package com.javarush.island.utilities;

import com.javarush.island.entities.Entity;
import com.javarush.island.entities.animals.herbivores.*;
import com.javarush.island.entities.animals.predators.*;
import com.javarush.island.entities.plants.Plant;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Settings {

    public static final String SALUTATION = "Приветствую тебя, мой дорогой друг!" +
            "Приступаем к созданию острова!";
    public static final String CREATE_MAP = "Введите размер карты.";
    public static final String INPUT_ROWS = "Введите длину острова: ";
    public static final String INPUT_COLS = "Введите ширину острова: ";
    public static final String NOT_KNOW_ERROR = "Упс! Что-то пошло не так";
    public static int ROWS;
    public static int COLS;

    public static final Set<? extends Entity> entitySet = new HashSet<>(Arrays.asList(
            new Boar(), new Buffalo(), new Caterpillar(), new Duck(), new Goat(), new Horse(),
            new Mouse(), new Rabbit(), new Reindeer(), new Sheep(), new Bear(), new Eagle(),
            new Fox(), new Snake(), new Wolf(), new Plant()
    ));

}
