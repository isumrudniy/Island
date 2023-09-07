package com.javarush.island.entities.animals.herbivores;

import com.javarush.island.utilities.Config;
import com.javarush.island.abstracts.Herbivore;
import com.javarush.island.utilities.YamlConfigReader;

import java.util.HashMap;

@Config(fileName = "config/animals/herbivores/boar.yaml")
public class Boar extends Herbivore {
}
