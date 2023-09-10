package com.javarush.island.utilities;

import com.javarush.island.entities.Entity;
import com.javarush.island.entities.animals.herbivores.*;
import com.javarush.island.entities.animals.predators.*;
import com.javarush.island.entities.plants.Plant;
import com.javarush.island.map.GameMap;
import com.javarush.island.map.Location;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Settings {

    public static final String SALUTATION = "Приветствую тебя, мой дорогой друг!" +
            "Приступаем к созданию острова!";
    public static final String CREATE_MAP = "Введите размер карты.";
    public static final String INPUT_ROWS = "Введите длину острова: ";
    public static final String INPUT_COLS = "Введите ширину острова: ";
    public static final String NOT_KNOW_ERROR = "Упс! Что-то пошло не так";
    public static int ROWS;
    public static int COLS;

    public static final int PERIOD = 6;
    public static final int TIMEOUT = 29;

    public static final List<? extends Entity> entitySet = new ArrayList<>(Arrays.asList(
            new Wolf(), new Snake(), new Fox(), new Bear(), new Eagle(), new Horse(), new Reindeer(),
            new Rabbit(), new Mouse(), new Goat(), new Sheep(), new Boar(), new Buffalo(), new Duck(), new Caterpillar(),
            new Plant()
    ));

    public static long calculateTotalEntityCount(GameMap gameMap) {
        return Stream.of(gameMap.getLocations())
                .flatMap(Stream::of)
                .mapToLong(location -> location.getEntityList().size())
                .sum();
    }

    public static void infoTotalEntity(GameMap gameMap) {
        Map<Entity, Long> entityCountMap = Stream.of(gameMap.getLocations())
                .flatMap(Stream::of)
                .flatMap(location -> location.getEntityList().stream())
                .collect(Collectors.groupingBy(
                        entity -> entity,
                        Collectors.counting()
                ));

        entityCountMap.forEach((entity, count) -> {
            System.out.print(entity.getIcon() + " " + count + " ");
        });
        System.out.println();
    }

}
