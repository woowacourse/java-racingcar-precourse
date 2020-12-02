package ui;

import java.util.Scanner;

public class Input {
    public static String receiveRacingCarNames(Scanner scanner) {
        Output.printRequestRacingCarNames();
        return scanner.nextLine();
    }
}