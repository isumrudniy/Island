package com.javarush.island;

import com.javarush.island.Abstracts.Animal;
import com.javarush.island.Animals.Rabbit;
import com.javarush.island.Animals.Wolf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Island {
    public static void main(String[] args) {
        Location[][] island = new Location[5][5];

        for (int i = 0; i < island.length; i++) {
            for (int j = 0; j < island[i].length; j++) {
                island[i][j] = new Location(i, j, new ArrayList<Animal>(Arrays.asList(new Wolf( new Random().nextDouble(7.9), 3, 3, 2), new Rabbit(1, 3, 4, 1))));
                System.out.println(island[i][j].toString());
            }
        }

    }
}
