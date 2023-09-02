package com.javarush.island.map;

import com.javarush.island.entities.Entities;
import com.javarush.island.entities.animals.herbivores.*;
import com.javarush.island.entities.animals.predators.*;
import com.javarush.island.entities.plants.Plant;
import com.javarush.island.map.Location;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

public class LocationFactory {
    public Location create(int x, int y) {
        Location location = new Location();
        location.setX(x);
        location.setY(y);
        location.setEntitiesList(createEntities());
        return location;
    }

    // Оптимизировать, значения брать из yaml (максимальное значение животных в одной локации)
    private List<Entities> createEntities() {
        List<Entities> entitiesList = new ArrayList<>();
        Random random = new Random();

        entitiesList.addAll(createEntityBatch(random, 30, Wolf::new));
        entitiesList.addAll(createEntityBatch(random, 30, Snake::new));
        entitiesList.addAll(createEntityBatch(random, 30, Fox::new));
        entitiesList.addAll(createEntityBatch(random, 5, Bear::new));
        entitiesList.addAll(createEntityBatch(random, 20, Eagle::new));
        entitiesList.addAll(createEntityBatch(random, 20, Horse::new));
        entitiesList.addAll(createEntityBatch(random, 20, Reindeer::new));
        entitiesList.addAll(createEntityBatch(random, 150, Rabbit::new));
        entitiesList.addAll(createEntityBatch(random, 200, Plant::new));

        return entitiesList;
    }

    private List<Entities> createEntityBatch(Random random, int count, Supplier<Entities> supplier) {
        List<Entities> batch = new ArrayList<>();
        for (int i = 0; i < random.nextInt(count); i++) {
            batch.add(supplier.get());
        }
        return batch;
    }

}
