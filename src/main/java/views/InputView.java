package views;

import java.util.Scanner;

public class InputView {
    private static final String INPUT_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_ROUND_NUMBER_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String EMPTY_INPUT = "[ERROR] 입력이 없습니다.";
    private static final String COMMA_LAST_UNAVAILABLE = "[ERROR] 쉼표는 마지막으로 입력할 수 없습니다.";
    private static final int CAR_NAME_LAST_INDEX = 1;
    private static final char SEPARATOR_CHAR = ',';
    private static final String EMPTY = "";

    public static String inputCarNames(Scanner scanner) {
        System.out.println(INPUT_CAR_NAME_MESSAGE);
        String carName = scanner.nextLine();
        isEmptyInput(carName);
        isCommaLast(carName);
        return carName;
    }

    public static String inputRoundNumber(Scanner scanner) {
        System.out.println(INPUT_ROUND_NUMBER_MESSAGE);
        String totalRound = scanner.nextLine();
        isEmptyInput(totalRound);
        return totalRound;
    }

    private static void isEmptyInput(String input) {
        if(input.equals(EMPTY)) {
            throw new IllegalArgumentException(EMPTY_INPUT);
        }
    }

    private static void isCommaLast(String carNames) {
        if (carNames.charAt(carNames.length() - CAR_NAME_LAST_INDEX) == SEPARATOR_CHAR) {
            throw new IllegalArgumentException(COMMA_LAST_UNAVAILABLE);
        }
    }
}




