package view;

import java.util.Scanner;

public class InputView {
    public static String inputPlayerName(Scanner scanner) {
        String next = scanner.next();

        return next;
    }

    public static int inputTryTimes(Scanner scanner) {
        int tryTimes = scanner.nextInt();

        return tryTimes;
    }
}
