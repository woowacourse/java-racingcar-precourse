package views;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final String INPUT_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String SEPARATOR = ",";
    private static final String INPUT_ROUND_NUMBER_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String EMPTY_EXCEPTION = "[ERROR] 공백을 입력할 수 없습니다.";
    private static final String EMPTY_INPUT = "";

    public static List<String> inputCarNames(Scanner scanner) {
        System.out.println(INPUT_CAR_NAME_MESSAGE);
        String carNames = scanner.nextLine();
        isEmptyValue(carNames);
        return Arrays.stream(carNames.split(SEPARATOR))
                .collect(Collectors.toList());
    }

    public static String inputRoundNumber(Scanner scanner) {
        System.out.println(INPUT_ROUND_NUMBER_MESSAGE);
        String roundNumber = scanner.nextLine();
        isEmptyValue(roundNumber);
        return roundNumber;
    }

    private static void isEmptyValue(String input) {
        if (input.equals(EMPTY_INPUT)) {
            throw new IllegalArgumentException(EMPTY_EXCEPTION);
        }
    }
}
