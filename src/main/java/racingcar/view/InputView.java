/**
 * InputView.java
 * 입력과 출력이 섞인 로직을 담당하는 View 클래스
 *
 * @author Kimun Kim / kkm97351@gmail.com
 */

package racingcar.view;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class InputView {
    private static final String REQUEST_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String REQUEST_TRY_NUMBER_MESSAGE = "시도할 회수는 몇회인가요?";

    private static Scanner scanner;

    public static void setScanner(Scanner scanner) {
        InputView.scanner = scanner;
    }

    private static String deleteWhiteSpaces(String string) {
        return string.replaceAll("\\s+", "");
    }

    private static boolean isEmptyStringOrThrowException(String string) {
        if (string.equals("")) {
            throw new IllegalArgumentException("입력값이 없습니다.");
        }
        return true;
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

    private static List<String> parseString(String rawString) {
        return new ArrayList<>(Arrays.asList(rawString.split(",")));
    }

    public static int getTryNumber() {
        System.out.println(REQUEST_TRY_NUMBER_MESSAGE);
        String rawString = deleteWhiteSpaces(scanner.nextLine());
        try {
            isEmptyStringOrThrowException(rawString);
            return parseIntOrThrowException(rawString);
        } catch (IllegalArgumentException e) {
            OutputView.showErrorMessage(e);
            return getTryNumber();
        }
    }

    private static int parseIntOrThrowException(String string) {
        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력해주세요.");
        }
    }

}
