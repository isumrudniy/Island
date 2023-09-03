package com.javarush.island.entities;

import com.javarush.island.behavior.Eatable;
import com.javarush.island.behavior.Movable;
import com.javarush.island.behavior.Reproducible;

public abstract class Entities implements Eatable, Movable, Reproducible {
    @Override
    public boolean isCanEat() {
        return false;
    }

    @Override
    public boolean isCanMove() {
        return false;
    }

    @Override
    public boolean isCanReproduce() {
        return false;
    }

    @Override
    public void eat() {

    }

    @Override
    public void move() {

    }

    @Override
    public void reproduce() {

    }
}
