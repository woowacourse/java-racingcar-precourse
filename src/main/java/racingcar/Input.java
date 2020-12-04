package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Input {

    public static ArrayList<String> askCarInfo(Scanner scanner) {
        String userInput = null;
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        if (scanner.hasNext() || userInput == null) {
            userInput = scanner.nextLine();
            System.out.println(userInput);
        }
        return parseCar(userInput, scanner);
    }

    public static ArrayList<String> parseCar(String userInput, Scanner scanner) {
        ArrayList<String> carList = new ArrayList<String>(Arrays.asList(userInput.split(",")));
        try {
            Validate.validateUserInput(userInput, carList);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            askCarInfo(scanner);
        }
        return carList;
    }

    public static Integer askRound(Scanner scanner) {
        int round = 0;
        if (scanner.hasNext()) {
            String roundString = scanner.next();
            try {
                Validate.isInteger(roundString);
                round = Integer.parseInt(roundString);
            } catch (IllegalArgumentException e) {
                System.out.println(e);
                round = askRound(scanner);
            }
        }
        return round;
    }


}
