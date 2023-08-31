package com.javarush.island.Abstracts;

public abstract class Animal {
    private double weight;
    private int maxVid;
    private int speed;
    private double amountFood;

    public Animal(double weight, int maxVid, int speed, double amountFood) {
        this.weight = weight;
        this.maxVid = maxVid;
        this.speed = speed;
        this.amountFood = amountFood;
    }

    @Override
    public String toString() {
        return weight + " " + maxVid + " " + speed;
    }
}
