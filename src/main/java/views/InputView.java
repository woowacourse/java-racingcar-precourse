package views;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class InputView {
    private static final String INPUT_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String EMPTY_INPUT = "";
    private static final String EXCEPTION_MESSAGE = "[ERROR] 공백을 입력할 수 없습니다.";
    private static final String SEPARATOR = ",";

    public Stream<String> inputCarNames(Scanner scanner) {
        System.out.println(INPUT_CAR_NAME_MESSAGE);
        String carNames = scanner.nextLine();
        isValidCarNames(carNames);
        return Arrays.stream(carNames.split(SEPARATOR));
    }

    void isValidCarNames(String carNames) {
        if (carNames.equals(EMPTY_INPUT)) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE);
        }
    }
}
