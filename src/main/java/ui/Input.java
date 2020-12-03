package ui;

import java.util.Scanner;

public class Input {

    public static String receiveRacingCarNames(Scanner scanner) {
        Output.printRequestRacingCarNames();
        return scanner.nextLine();
    }

    public static String receiveAttemptsCount(Scanner scanner) {
        Output.printRequestAttemptsCount();
        return scanner.nextLine();
    }

    public static void validateEmpty(String input) {
        if (input == "") {
            throw new IllegalArgumentException("[Error] 빈 값을 넣으시면 안 됩니다.");
        }
    }
}