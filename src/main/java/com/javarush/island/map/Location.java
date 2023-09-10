package com.javarush.island.map;

import com.javarush.island.behavior.Eatable;
import com.javarush.island.behavior.Movable;
import com.javarush.island.behavior.Reproducible;
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

public class Location implements Reproducible, Eatable, Movable {
    private int x;
    private int y;
    private volatile List<Entity> entityList = new ArrayList<>();

    @Override
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

    @Override
    public void eatEntity() {

    }

    @Override
    public void reproduceEntity() {
        List<Entity> addList = new ArrayList<>();

        try {
            entityList.sort((obj1, obj2) -> obj1.hashCode() - obj2.hashCode());
        } catch (IllegalArgumentException e) {
        }

        for (int i = 1; i < entityList.size(); i += 2) {
            if ((entityList.get(i - 1).equals(entityList.get(i))) && (new Random().nextInt(100) > 80)) {
                addList.add(entityList.get(i).createNewEntity());
            }
        }

        addList.forEach(addEntity ->
        {
            long count = entityList.stream()
                    .filter(entity -> entity.equals(addEntity))
                    .count();
            if (count < addEntity.getMaxAmount()) {
                entityList.add(addEntity);
            }
        });
    }

}
