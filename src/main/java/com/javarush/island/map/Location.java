package com.javarush.island.map;

import com.javarush.island.behavior.Movable;
import com.javarush.island.entities.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Location implements Movable {
    private int x;
    private int y;
    private volatile List<Entity> entityList = new ArrayList<>();

    @Override
    public void move() {

        GameMap gameMap = GameMap.getInstance();

        Iterator<Entity> entityIterator = entityList.iterator();
        while (entityIterator.hasNext()) {

            Entity nextEntity = entityIterator.next();
            Location newLocation = getNewLocation(gameMap, nextEntity);

            if (newLocation != null) {
                isCanMove(newLocation, nextEntity);
                newLocation.entityList.add(nextEntity);
                entityIterator.remove();
            }
        }

    }

    private boolean isCanMove(Location location, Entity entity) {
        long count = location.getEntityList().stream().filter(obj ->
                obj.getClass().equals(entity.getClass())
        ).count();
        return false;
    }

    private Location getNewLocation(GameMap gameMap, Entity entity) {
        int newX = x;
        int newY = y;
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

        if (newX != x || newY != y) {
            return gameMap.getLocation(newX, newY);
        } else {
            return null;
        }
    }

}
