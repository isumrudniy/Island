package com.javarush.island;

public class Main {
    public static void main(String[] args) {
        Location[][] gameMap = new Location[5][5];

        LocationFactory locationFactory = new LocationFactory();

        for (int i = 0; i < gameMap.length; i++) {
            for (int j = 0; j < gameMap[i].length; j++) {
                gameMap[i][j] = locationFactory.create(i, j);
            }
        }

        for (var map: gameMap
             ) {
            for (var loc: map
                 ) {
                System.out.println(loc);
            }
            System.out.println();
        }

    }
}
