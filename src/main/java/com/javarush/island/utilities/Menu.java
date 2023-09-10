package com.javarush.island.utilities;

import com.javarush.island.map.GameMap;
import com.javarush.island.treads.Task;

import java.util.Scanner;
import java.util.concurrent.*;

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

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(Runtime.getRuntime().availableProcessors());

        long sizeBefore = Settings.calculateTotalEntityCount(gameMap);
        System.out.println("Количество существ: " + sizeBefore);

        ScheduledFuture<?> scheduledFuture = executorService.scheduleAtFixedRate(new Task(), 0, Settings.PERIOD, TimeUnit.SECONDS);

        try {
            TimeUnit.SECONDS.sleep(Settings.TIMEOUT);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Останавливаем выполнение задачи и закрываем executorService
        scheduledFuture.cancel(true);
        executorService.shutdown();

    }
}
