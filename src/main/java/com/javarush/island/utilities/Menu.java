package com.javarush.island.utilities;

import com.javarush.island.map.GameMap;
import com.javarush.island.treads.Task;

import java.util.Scanner;
import java.util.concurrent.*;

public class Menu {
    public static void openMenu() {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println(Settings.SALUTATION + "\n" + Settings.CREATE_MAP);
            System.out.println(Settings.INPUT_ROWS);

            while (true) {
                if (sc.hasNextInt()) {
                    int size = sc.nextInt();
                    if (size > 0) {
                        Settings.ROWS = size;
                        break;
                    } else {
                        System.out.println("Введите число больше 0!");
                    }
                } else {
                    System.out.println("Введите число!");
                    sc.next(); // Очистка некорректного ввода
                }
            }

            System.out.println(Settings.INPUT_COLS);

            while (true) {
                if (sc.hasNextInt()) {
                    int size = sc.nextInt();
                    if (size > 0) {
                        Settings.COLS = size;
                        break;
                    } else {
                        System.out.println("Введите число больше 0!");
                    }
                } else {
                    System.out.println("Введите число!");
                    sc.next(); // Очистка некорректного ввода
                }
            }

        }

        // Инициализация острова
        GameMap gameMap = GameMap.getInstance();

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(Runtime.getRuntime().availableProcessors());

        long sizeBefore = Settings.calculateTotalEntityCount(gameMap);
        System.out.println("Старт. Количество существ: " + sizeBefore);
        Settings.infoTotalEntity(gameMap);

        ScheduledFuture<?> scheduledFuture = executorService.scheduleAtFixedRate(new Task(), 0, Settings.PERIOD, TimeUnit.SECONDS);

        try {
            TimeUnit.SECONDS.sleep(Settings.TIMEOUT);
        } catch (InterruptedException e) {
            throw new RuntimeException(e.getMessage());
        }

        // Останавливаем выполнение задачи и закрываем executorService
        scheduledFuture.cancel(true);
        executorService.shutdown();

    }
}
