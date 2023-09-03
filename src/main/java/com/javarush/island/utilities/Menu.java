package com.javarush.island.utilities;

import com.javarush.island.entities.animals.predators.Wolf;
import com.javarush.island.map.Location;
import com.javarush.island.map.GameMap;

import java.util.Scanner;

public class Menu {
    public static void openMenu() {

        try (Scanner sc = new Scanner(System.in)) {
            System.out.println(Settings.SALUTATION + "\n" + Settings.CREATE_MAP);
            System.out.print(Settings.INPUT_ROWS);
            Settings.ROWS = sc.nextInt();
            System.out.print(Settings.INPUT_COLS);
            Settings.COLS = sc.nextInt();
        } catch (Exception e) {
            System.out.println(Settings.NOT_KNOW_ERROR);
        }

        // Инициализация острова
        GameMap gameMap = GameMap.getInstance();

        // Для проверки реализации

        for (var map : gameMap.locations
        ) {
            for (var loc : map
            ) {
                System.out.println(loc);
                System.out.println(loc.getX() + " " + loc.getY());
                loc.getEntitiesList().forEach(entity -> System.out.println(entity instanceof Wolf));
                System.out.println("===========================");
            }
            System.out.println();
            System.out.println();
        }
    }
}
