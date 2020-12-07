package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Input {

    public static ArrayList<String> askCarInfo(Scanner scanner) {
//        String userInput = null;
//        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
//        if (scanner.hasNext() || userInput == null) {
//            userInput = scanner.nextLine();
//        }
//        return parseCar(userInput, scanner);
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return parseCar(scanner.nextLine(), scanner);
    }

    public static ArrayList<String> parseCar(String carInfoString, Scanner scanner) {
        ArrayList<String> carList = new ArrayList<String>(Arrays.asList(carInfoString.split(",")));
        try {
            Validate.validateCarName(carInfoString, carList);
            return carList;
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            return askCarInfo(scanner);
        }
    }

    public static Integer askRound(Scanner scanner) {
        System.out.println("시도할 회수는 몇회인가요?");
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
