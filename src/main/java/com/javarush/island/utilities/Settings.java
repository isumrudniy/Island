package com.javarush.island.utilities;

import com.javarush.island.entities.Entity;
import com.javarush.island.entities.animals.herbivores.*;
import com.javarush.island.entities.animals.predators.*;
import com.javarush.island.entities.plants.Plant;

import java.util.*;

public class Settings {

    public static final String SALUTATION = "Приветствую тебя, мой дорогой друг!" +
            "Приступаем к созданию острова!";
    public static final String CREATE_MAP = "Введите размер карты.";
    public static final String INPUT_ROWS = "Введите длину острова: ";
    public static final String INPUT_COLS = "Введите ширину острова: ";
    public static final String NOT_KNOW_ERROR = "Упс! Что-то пошло не так";
    public static int ROWS;
    public static int COLS;

    public static final List<? extends Entity> entitySet = new ArrayList<>(Arrays.asList(
            new Wolf(), new Snake(), new Fox(), new Bear(), new Eagle(), new Horse(), new Reindeer(),
            new Rabbit(), new Mouse(), new Goat(), new Sheep(), new Boar(), new Buffalo(), new Duck(), new Caterpillar(),
            new Plant()
    ));

}
