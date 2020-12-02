package racingcar.game;

import java.util.Scanner;

public class UserInputCarNames {

    public void getInputFromUser(Scanner scanner) {
        InputPrint.printMessageForInputCarNames();
        String inputStr;
        do {
            inputStr = getInputCarNames(scanner);
            System.out.println(inputStr);
        } while (true);
    }

    private String getInputCarNames(Scanner scanner) {
        return scanner.nextLine();
    }
}
