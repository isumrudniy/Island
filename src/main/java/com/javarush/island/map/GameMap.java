package com.javarush.island.map;

import com.javarush.island.utilities.Settings;

public class GameMap {
    private static GameMap instance;
    public Location[][] locations;

    private GameMap() {
        createMap();
    }

    public static GameMap getInstance() {
        if (instance == null) {
            instance = new GameMap();
        }
        return instance;
    }

    private void createMap() {

        locations = new Location[Settings.ROWS][Settings.COLS];

        LocationFactory locationFactory = new LocationFactory();

        for (int i = 0; i < locations.length; i++) {
            for (int j = 0; j < locations[i].length; j++) {
                locations[i][j] = locationFactory.create(i, j);
            }
        }
    }

}
