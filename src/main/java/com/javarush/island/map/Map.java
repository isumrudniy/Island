package com.javarush.island.map;

import com.javarush.island.utilities.Settings;

public class Map {

    public static Location[][] map() {

        Location[][] map = new Location[Settings.ROWS][Settings.COLS];

        LocationFactory locationFactory = new LocationFactory();

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = locationFactory.create(i, j);
            }
        }
        return map;
    }

}
