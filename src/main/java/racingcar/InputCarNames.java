package racingcar;

import exception.IllegalDuplicateException;
import exception.IllegalLengthException;
import java.util.Arrays;
import java.util.Scanner;

public class InputCarNames {

    private final static int MAX_CAR_NAME = 5;

    public static String[] getCarNames(Scanner scanner) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNamesInputString;
        String[] carNames;
        try {
            carNamesInputString = scanner.nextLine();
            carNames = carNamesInputString.split(",\\s*");
        } catch (Exception e) {
            System.out.println("[ERROR] 잘못된 입력값입니다.");
            throw new IllegalArgumentException();
        }
        if (carNames.length == 0) {
            System.out.println("[ERROR] 경주할 자동차가 존재하지 않습니다.");
            throw new IllegalStateException();
        }
        validateCarNameLength(carNames);
        validateCarNameDuplicate(carNames);
        return carNames;
    }

    private static void validateCarNameLength(String[] carNames) {
        for (String carName : carNames) {
            if (carName.length() > MAX_CAR_NAME) {
                throw new IllegalLengthException();
            }
        }
    }

    private static void validateCarNameDuplicate(String[] carNames) {
        Arrays.sort(carNames);

        for (int i = 0; i < carNames.length - 1; i++) {
            if (carNames[i].equals(carNames[i + 1])) {
                throw new IllegalDuplicateException();
            }
        }
    }
}
