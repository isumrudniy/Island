package com.javarush.island.utilities;

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

        int sizeBefore = 0;
        int sizeAfter = 0;

        //  Для проверки реализации. После удалить! {

        for (var map : gameMap.getLocations()
        ) {
            for (var loc : map
            ) {
                sizeBefore += loc.getEntityList().size();
            }
        }

        for (var map : gameMap.getLocations()
        ) {
            for (var loc : map
            ) {
                loc.move();
            }
        }

        for (var map : gameMap.getLocations()
        ) {
            for (var loc : map
            ) {
                sizeAfter += loc.getEntityList().size();
            }
        }

        //  }
        System.out.println("Размер до: " + sizeBefore);
        System.out.println("Размер после: " + sizeAfter);
    }
}
