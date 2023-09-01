package com.javarush.island;

import com.javarush.island.entities.Entities;
import com.javarush.island.entities.animals.herbivores.Horse;
import com.javarush.island.entities.animals.herbivores.Rabbit;
import com.javarush.island.entities.animals.herbivores.Reindeer;
import com.javarush.island.entities.animals.predators.*;
import com.javarush.island.entities.plants.Plant;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LocationFactory {
    public Location create(int x, int y) {
        Location location = new Location();
        location.setX(x);
        location.setY(y);
        location.setEntitiesList(createEntities());
        return location;
    }

    // Оптимизировать, значения брать из yaml
    private List<Entities> createEntities() {
        List<Entities> entitiesList = new ArrayList<>();
        for (int i = 0; i < new Random().nextInt(30); i++) {
            entitiesList.add(new Wolf());
        }

        for (int i = 0; i < new Random().nextInt(30); i++) {
            entitiesList.add(new Snake());
        }

        for (int i = 0; i < new Random().nextInt(30); i++) {
            entitiesList.add(new Fox());
        }

        for (int i = 0; i < new Random().nextInt(5); i++) {
            entitiesList.add(new Bear());
        }

        for (int i = 0; i < new Random().nextInt(20); i++) {
            entitiesList.add(new Eagle());
        }

        for (int i = 0; i < new Random().nextInt(20); i++) {
            entitiesList.add(new Horse());
        }

        for (int i = 0; i < new Random().nextInt(20); i++) {
            entitiesList.add(new Reindeer());
        }

        for (int i = 0; i < new Random().nextInt(150); i++) {
            entitiesList.add(new Rabbit());
        }

        for (int i = 0; i < new Random().nextInt(200); i++) {
            entitiesList.add(new Plant());
        }

        return entitiesList;
    }
}
