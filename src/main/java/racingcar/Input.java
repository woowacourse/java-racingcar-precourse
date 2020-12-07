package racingcar;

import java.util.ArrayList;
import java.util.Scanner;

public class Input {

    public static final String MSG_ASK_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String MSG_ASK_ROUND_NUMBER = "시도할 회수는 몇회인가요?";

    public static ArrayList<String> askCarInfo(Scanner scanner) {
        System.out.println(MSG_ASK_CAR_NAMES);
        return parseCar(scanner.nextLine(), scanner);
    }

    public static ArrayList<String> parseCar(String carInfoString, Scanner scanner) {
        try {
            ArrayList<String> carList = Validate.validateCarName(carInfoString);
            return carList;
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            return askCarInfo(scanner);
        }
    }

    public static Integer askRound(Scanner scanner) {
        System.out.println(MSG_ASK_ROUND_NUMBER);
        return parseRound(scanner.nextLine(), scanner);
    }

    public static Integer parseRound(String roundInput, Scanner scanner) {
        try {
            return Validate.validateRound(roundInput);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            return askRound(scanner);
        }
    }
}
