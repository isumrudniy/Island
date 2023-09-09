package com.javarush.island.entities;

import com.javarush.island.behavior.Eatable;
import com.javarush.island.behavior.Movable;
import com.javarush.island.behavior.Reproducible;
import com.javarush.island.map.GameMap;
import com.javarush.island.map.Location;
import com.javarush.island.utilities.YamlConfigReader;
import lombok.Getter;
import lombok.Setter;

import java.util.*;
import java.util.function.Supplier;

@Getter
@Setter
public abstract class Entity implements Movable, Eatable, Reproducible, Supplier {

    private String name;
    private String icon;
    private double maxWeight;
    private int maxAmount;
    private int maxSpeed;
    private double maxFood;

    private Map<Entity,Integer> eatableTable;

    // non-static
    {
        YamlConfigReader configReader = new YamlConfigReader(this.getClass());
        HashMap<String, Object> configMap = configReader.getConfigMap();
        try {
            name = (String) configMap.get("name");
            icon = (String) configMap.get("icon");
            maxWeight = (Double) configMap.get("maxWeight");
            maxAmount = (Integer) configMap.get("maxAmount");
            maxSpeed = (Integer) configMap.get("maxSpeed");
            maxFood = (Double) configMap.get("maxFood");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Entity get() {
        return this;
    }

    @Override
    public Location move(Location location) {

        GameMap gameMap = GameMap.getInstance();

        int newX = location.getX();
        int newY = location.getY();
        Random random = new Random();

        for (int step = 0; step < 2; step++) {
            int randomDirection = random.nextInt(4); // 0 - вправо, 1 - влево, 2 - вверх, 3 - вниз

            switch (randomDirection) {
                case 0 -> { // Вправо
                    if (newY < gameMap.getLocations()[0].length - 1) {
                        newY++;
                    }
                }
                case 1 -> { // Влево
                    if (newY > 0) {
                        newY--;
                    }
                }
                case 2 -> { // Вверх
                    if (newX > 0) {
                        newX--;
                    }
                }
                case 3 -> { // Вниз
                    if (newX < gameMap.getLocations().length - 1) {
                        newX++;
                    }
                }
            }
        }

        Location newLocation = gameMap.getLocation(newX, newY);

        if ((newX != location.getX() || newY != location.getY()) && isCanMove(newLocation)) {
            return newLocation;
        } else {
            return null;
        }
    }

    private boolean isCanMove(Location location) {
        long count = location.getEntityList().stream().filter(obj ->
                obj.getClass().equals(this.getClass())
        ).count();
        return (count <= this.maxAmount);
    }

    @Override
    public void eat(Location location) {

    }

    @Override
    public boolean isCanEat() {
        return false;
    }

    @Override
    public void reproduce(List<Entity> entityList) {

    }

    @Override
    public boolean isCanReproduce(List<Entity> entityList) {
        return false;
    }
}
