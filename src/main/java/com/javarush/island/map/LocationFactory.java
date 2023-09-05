package com.javarush.island.map;

import com.javarush.island.entities.Entity;
import com.javarush.island.entities.animals.predators.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

public class LocationFactory {
    public Location create(int x, int y) {
        Location location = new Location();
        location.setX(x);
        location.setY(y);
        location.setEntityList(createEntities(x, y));
        return location;
    }

    // Оптимизировать, значения брать из yaml (максимальное значение животных в одной локации)
    private List<Entity> createEntities(int x, int y) {
        List<Entity> entityList = new ArrayList<>();
        Random random = new Random();

        entityList.addAll(createEntityBatch(random, 30, Wolf::new));
//        entitiesList.addAll(createEntityBatch(random, 30, Snake::new));
//        entitiesList.addAll(createEntityBatch(random, 30, Fox::new));
//        entitiesList.addAll(createEntityBatch(random, 5, Bear::new));
//        entitiesList.addAll(createEntityBatch(random, 20, Eagle::new));
//        entitiesList.addAll(createEntityBatch(random, 20, Horse::new));
//        entitiesList.addAll(createEntityBatch(random, 20, Reindeer::new));
//        entitiesList.addAll(createEntityBatch(random, 150, Rabbit::new));
//        entitiesList.addAll(createEntityBatch(random, 200, Plant::new));
        return entityList;
    }

    private List<Entity> createEntityBatch(Random random, int count, Supplier<Entity> supplier) {
        List<Entity> batch = new ArrayList<>();
        for (int i = 0; i < random.nextInt(count); i++) {
            batch.add(supplier.get());
        }
        return batch;
    }

}
