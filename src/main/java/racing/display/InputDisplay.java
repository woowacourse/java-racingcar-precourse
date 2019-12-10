package racing.display;

import racing.validator.InputValidator;

import java.util.List;
import java.util.Scanner;

public class InputDisplay {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String ROUND_MESSAGE = "시도할 회수는 몇회인가요? [두자리수 이하 양의정수 입력]";

    public static List<String> getCarNames() {
        return null;
    }

    public static int getRound() {
        String data = "";
        boolean isValidResult = false;

        while (!isValidResult) {
            System.out.println(ROUND_MESSAGE);
            data = SCANNER.nextLine();
            isValidResult = InputValidator.isValidRound(data);
        }
        return Integer.parseInt(data);
    }
}
