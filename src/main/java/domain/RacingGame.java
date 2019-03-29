package domain;

import java.util.Scanner;
public class RacingGame {

    private String getInputConsole() {
        Scanner sc = new Scanner(System.in);

        return sc.nextLine();
    }

    private boolean isValidInput(String input) {
        if (input.length() > 5 && !input.contains(",")) {
            return false;
        }
        return true;
    }

    private boolean isNumber(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }
}
