package com.javarush.island.utilities;

import com.javarush.island.entities.animals.predators.Wolf;
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

        for (var locations : gameMap.getLocations()
        ) {
            for (var location : locations
            ) {
                sizeBefore += location.getEntityList().size();
                System.out.println(location.getEntityList().stream().filter(obj -> obj.getClass().equals(Wolf.class))
                        .count());
            }
        }

        for (int i = 0; i < 2; i++) {
            for (var locations : gameMap.getLocations()
            ) {
                for (var location : locations
                ) {
                    location.moveEntity();
                }
            }
            System.out.println("Выполнено перемещение животных!");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        for (var locations : gameMap.getLocations()
        ) {
            for (var location : locations
            ) {
                sizeAfter += location.getEntityList().size();
                System.out.println(location.getEntityList().stream().filter(obj -> obj.getClass().equals(Wolf.class))
                        .count());
            }
        }

        System.out.println("Размер до: " + sizeBefore);
        System.out.println("Размер после: " + sizeAfter);
    }
}
