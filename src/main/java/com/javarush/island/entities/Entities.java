package com.javarush.island.entities;

import com.javarush.island.behavior.Eatable;
import com.javarush.island.behavior.Movable;
import com.javarush.island.behavior.Reproducible;
import com.javarush.island.map.GameMap;
import com.javarush.island.map.Location;

import java.util.Random;

public abstract class Entities implements Eatable, Movable, Reproducible {
    private int x;
    private int y;
    private int id;

    public void setEntityParam(int x, int y, int id) {
        this.x = x;
        this.y = y;
        this.id = id;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean isCanEat() {
        return false;
    }

    @Override
    public boolean isCanMove() {
        return false;
    }

    @Override
    public boolean isCanReproduce() {
        return false;
    }

    @Override
    public void eat() {

    }

    @Override
    public void move() {
        GameMap gameMap = GameMap.getInstance();

        int newX = x;
        int newY = y;

        Random random = new Random();

        for (int step = 0; step < 2; step++) {
            int randomDirection = random.nextInt(4); // 0 - вправо, 1 - влево, 2 - вверх, 3 - вниз

            switch (randomDirection) {
                case 0: // Вправо
                    if (y < gameMap.getLocations()[0].length - 1) {
                        newY++;
                    }
                    break;
                case 1: // Влево
                    if (y > 0) {
                        newY--;
                    }
                    break;
                case 2: // Вверх
                    if (x > 0) {
                        newX--;
                    }
                    break;
                case 3: // Вниз
                    if (x < gameMap.getLocations().length - 1) {
                        newX++;
                    }
                    break;
            }
        }
        if (newX != x || newY != y) {
            Location location = gameMap.getLocation(newX, newY);
        }
    }

    @Override
    public void reproduce() {

    }
}
