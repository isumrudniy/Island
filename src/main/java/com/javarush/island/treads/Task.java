package com.javarush.island.treads;

import com.javarush.island.map.GameMap;
import com.javarush.island.utilities.Settings;

public class Task implements Runnable {
    @Override
    public void run() {

        GameMap gameMap = GameMap.getInstance();

        for (var locations : gameMap.getLocations()) {
            for (var location : locations) {
                synchronized (location) {
                    location.moveEntity();
                    location.eatEntity();
                    location.reproduceEntity();
                }
            }
        }

        long sizeAfter = Settings.calculateTotalEntityCount(gameMap);
        System.out.println("Количество существ: " + sizeAfter);
        Settings.infoTotalEntity(gameMap);
    }
}
