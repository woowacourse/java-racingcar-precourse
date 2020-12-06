package racingcar.view;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class InputView {
    private static final String REQUEST_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

    private static Scanner scanner;

    public static void setScanner(Scanner scanner) {
        InputView.scanner = scanner;
    }

    public static List<String> getCarNames() {
        System.out.println(REQUEST_CAR_NAMES_MESSAGE);
        String rawString = deleteWhiteSpaces(scanner.nextLine());
        try {
            isEmptyStringOrThrowException(rawString);
            return parseString(rawString);
        } catch (IllegalArgumentException e) {
            OutputView.showErrorMessage(e);
            return getCarNames();
        }
    }

    private static String deleteWhiteSpaces(String string) {
        return string.replaceAll("\\s+", "");
    }

    private static List<String> parseString(String rawString) {
        return new ArrayList<>(Arrays.asList(rawString.split(",")));
    }

    private static boolean isEmptyStringOrThrowException(String string) {
        if (string.equals("")) {
            throw new IllegalArgumentException("입력값이 없습니다.");
        }
        return true;
    }
}
