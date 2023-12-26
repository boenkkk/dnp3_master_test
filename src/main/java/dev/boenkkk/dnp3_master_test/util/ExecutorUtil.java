package dev.boenkkk.dnp3_master_test.util;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;

public class ExecutorUtil {

    public static void handleUserInput(ExecutorService executor) {
        executor.submit(() -> {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                String userInput = scanner.nextLine();
                if ("x".equalsIgnoreCase(userInput)) {
                    executor.shutdownNow();
                    break;
                }
            }
        });
    }
}
