package com.javarush.island.behavior;

import com.javarush.island.map.Location;

public interface Eatable {
    void eat(Location location);

    boolean isCanEat();
}
