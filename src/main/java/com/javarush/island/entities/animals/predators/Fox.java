package com.javarush.island.entities.animals.predators;

import com.javarush.island.abstracts.Predator;
import com.javarush.island.entities.Entity;
import com.javarush.island.entities.animals.herbivores.Caterpillar;
import com.javarush.island.entities.animals.herbivores.Duck;
import com.javarush.island.entities.animals.herbivores.Mouse;
import com.javarush.island.entities.animals.herbivores.Rabbit;
import com.javarush.island.entities.plants.Plant;
import com.javarush.island.utilities.Config;

import java.util.HashMap;
import java.util.Map;

@Config(fileName = "config/animals/predators/fox.yaml")
public class Fox extends Predator {

    {
        Map<Entity, Integer> eatableTable = new HashMap<>() {{
            put(new Rabbit(), 70);
            put(new Mouse(), 90);
            put(new Duck(), 60);
            put(new Caterpillar(), 40);
        }};

        super.setEatableTable(eatableTable);

    }

}
