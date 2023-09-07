package com.javarush.island;

import com.javarush.island.entities.animals.herbivores.Boar;
import com.javarush.island.utilities.Menu;
import com.javarush.island.utilities.YamlConfigReader;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

//        YamlConfigReader configReader = new YamlConfigReader(Boar.class);
//        HashMap<String, Object> configMap = configReader.getConfigMap();

        Menu.openMenu();
    }
}
