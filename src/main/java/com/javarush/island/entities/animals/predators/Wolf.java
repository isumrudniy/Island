package com.javarush.island.entities.animals.predators;

import com.javarush.island.abstracts.Predator;
import com.javarush.island.entities.animals.herbivores.Boar;
import com.javarush.island.utilities.Config;
import com.javarush.island.utilities.YamlConfigReader;

import java.util.HashMap;


@Config(fileName = "config/animals/predators/wolf.yaml")
public class Wolf extends Predator {
}
