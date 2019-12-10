package racing.display;

import racing.validator.InputValidator;

import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class InputDisplay {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String ROUND_MESSAGE = "시도할 회수는 몇회인가요? [두자리수 이하 양의정수 입력]";
    private static final String CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

    public static List<String> getCarNames() {
        String data = getValidData(CAR_NAMES_MESSAGE, InputValidator::isValidNames);
        return null;
    }

    public static int getRound() {
        String data = getValidData(ROUND_MESSAGE, InputValidator::isValidRound);
        return Integer.parseInt(data);
    }

    private static String getValidData(String message, Predicate<String> validFunction) {
        String data = "";
        boolean isValidResult = false;

        while (!isValidResult) {
            System.out.println(message);
            data = SCANNER.nextLine();
            isValidResult = validFunction.test(data);
        }
        return data;
    }

}
