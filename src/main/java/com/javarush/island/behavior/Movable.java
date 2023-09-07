package com.javarush.island.behavior;

import com.javarush.island.entities.Entity;
import com.javarush.island.map.Location;

public interface Movable {
    Location move(Location location);
}
