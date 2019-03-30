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

    private void invalidInputMessage() {
        System.out.println("잘못된 입력입니다.");
    }

    private String[] splitCarName(String input) {
        return input.split(",");
    }

    private CarGroup reacyCarGroup(String input) {
        String[] names = splitCarName(input);

        CarGroup cg = new CarGroup(names);

        return cg;
    }

    private void printConsole(String string) {
        System.out.println(string);
    }

}
