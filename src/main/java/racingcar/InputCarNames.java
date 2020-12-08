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
            carNamesInputString = scanner.next();
            carNames = carNamesInputString.split(",");
        } catch (Exception e) {
            System.out.println("[ERROR] 잘못된 입력값입니다.");
            throw new IllegalArgumentException();
        }
        if (carNames.length == 0) {
            System.out.println("[ERROR] 경주할 자동차가 존재하지 않습니다.");
            throw new IllegalStateException();
        }
        if (!validateCarNameLength(carNames))
            throw new IllegalLengthException();
        if (!validateCarNameDuplicate(carNames))
            throw new IllegalDuplicateException();
        return carNames;
    }

    private static boolean validateCarNameLength(String[] carNames) {
        for (String carName : carNames) {
            if (carName.length() > MAX_CAR_NAME) {
                return false;
            }
        }
        return true;
    }

    private static boolean validateCarNameDuplicate(String[] carNames) {
        Arrays.sort(carNames);

        for (int i = 0; i < carNames.length - 1; i++) {
            if (carNames[i].equals(carNames[i + 1])) {
                return false;
            }
        }
        return true;
    }
}
