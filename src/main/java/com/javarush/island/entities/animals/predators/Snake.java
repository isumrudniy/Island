package com.javarush.island.entities.animals.predators;

import com.javarush.island.abstracts.Predator;
import com.javarush.island.entities.Entity;
import com.javarush.island.entities.animals.herbivores.Duck;
import com.javarush.island.entities.animals.herbivores.Mouse;
import com.javarush.island.entities.animals.herbivores.Rabbit;
import com.javarush.island.utilities.Config;

import java.util.HashMap;
import java.util.Map;

@Config(fileName = "config/animals/predators/snake.yaml")
public class Snake extends Predator {

    {
        Map<Entity, Integer> eatableTable = new HashMap<>() {{
            put(new Fox(), 15);
            put(new Rabbit(), 20);
            put(new Mouse(), 40);
            put(new Duck(), 10);
        }};

        super.setEatableTable(eatableTable);

    }

}
