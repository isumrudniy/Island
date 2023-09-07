package com.javarush.island.map;

import com.javarush.island.behavior.Movable;
import com.javarush.island.entities.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Location {
    private int x;
    private int y;
    private volatile List<Entity> entityList = new ArrayList<>();

    public void moveEntity() {

        GameMap gameMap = GameMap.getInstance();

        Iterator<Entity> entityIterator = entityList.iterator();

        while (entityIterator.hasNext()) {

            Entity nextEntity = entityIterator.next();

            Location newLocation = nextEntity.move(this);

            if (newLocation != null) {
                newLocation.entityList.add(nextEntity);
                entityIterator.remove();
            }
        }
    }

}
