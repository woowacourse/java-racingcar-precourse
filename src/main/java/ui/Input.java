package ui;

import java.util.Scanner;
import racingcar.ErrorMessage;

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
            throw new IllegalArgumentException(ErrorMessage.SHOULD_NOT_INPUT_EMPTY);
        }
    }
}