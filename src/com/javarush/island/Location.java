package com.javarush.island;

import com.javarush.island.Abstracts.Animal;
import com.javarush.island.Abstracts.Plant;

import java.util.ArrayList;

public class Location {
    private int x;
    private int y;
    private ArrayList<Animal> animals;
    private ArrayList<Plant> plants;

    public Location(int x, int y, ArrayList<Animal> animals) {
        this.x = x;
        this.y = y;
        this.animals = animals;
        this.plants = plants;
    }

    @Override
    public String toString() {
        return "Cell " + x + " " + y + " " + animals;
    }

    public String printInfo() {
        return animals.get(0).toString();
    }
}
