package com.javarush.island;

import com.javarush.island.Abstracts.Animal;
import com.javarush.island.Animals.Rabbit;
import com.javarush.island.Animals.Wolf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Island {
    private final int ROWS = 5;
    private final int COLS = 5;
    private Location[][] locations;

    public Island() {
        this.locations = new Location[ROWS][COLS];
    }

    public static void main(String[] args) {
        Island island = new Island();

        for (int i = 0; i < island.locations.length; i++) {
            for (int j = 0; j < island.locations[i].length; j++) {
                island.locations[i][j] = new Location(i, j, new ArrayList<Animal>(Arrays.asList(new Wolf(new Random().nextDouble(7.9), 3, 3, 2), new Rabbit(1, 3, 4, 1))));
                System.out.println(island.locations[i][j].toString());
            }
        }

    }
}
