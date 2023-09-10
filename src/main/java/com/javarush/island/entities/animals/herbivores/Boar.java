package com.javarush.island.entities.animals.herbivores;

import com.javarush.island.entities.Entity;
import com.javarush.island.entities.plants.Plant;
import com.javarush.island.utilities.Config;
import com.javarush.island.abstracts.Herbivore;

import java.util.HashMap;
import java.util.Map;

@Config(fileName = "config/animals/herbivores/boar.yaml")
public class Boar extends Herbivore {

    {
        Map<Entity, Integer> eatableTable = new HashMap<>() {{
            put(new Mouse(), 50);
            put(new Caterpillar(), 90);
            put(new Plant(), 100);
        }};

        super.setEatableTable(eatableTable);

    }

}
