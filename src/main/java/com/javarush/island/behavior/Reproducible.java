package com.javarush.island.behavior;

import com.javarush.island.entities.Entity;

import java.util.List;

public interface Reproducible {
    void reproduce(List<Entity> entityList);

    boolean isCanReproduce(List<Entity> entityList);
}
