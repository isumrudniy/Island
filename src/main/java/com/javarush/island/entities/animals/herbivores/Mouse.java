package com.javarush.island.entities.animals.herbivores;

import com.javarush.island.abstracts.Herbivore;
import com.javarush.island.entities.Entity;
import com.javarush.island.entities.plants.Plant;
import com.javarush.island.utilities.Config;

import java.util.HashMap;
import java.util.Map;

@Config(fileName = "config/animals/herbivores/mouse.yaml")
public class Mouse extends Herbivore {

    {
        Map<Entity, Integer> eatableTable = new HashMap<>() {{
            put(new Caterpillar(), 100);
            put(new Plant(), 100);
        }};

        super.setEatableTable(eatableTable);

    }

}
