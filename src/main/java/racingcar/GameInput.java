package racingcar;

import java.util.Scanner;

public class GameInput {
    public static final String INPUT_ROUND_MESSAGE = "시도할 횟수를 입력해주세요: ";
    public static final String ERROR_PREFIX = "[ERROR] ";
    public static final String INVALID_ROUND_INPUT_NOT_INTEGER_MESSAGE = "시도 횟수는 숫자여야 한다.";
    public static final String INVALID_ROUND_INPUT_SMALLER_THAN_ZERO_MESSAGE = "시도 횟수는 0보다 큰 숫자여야 한다.";
    public static final String INPUT_CAR_NAMES_MESSAGE = "경주 할 자동차 이름(이름은 쉼표(,) 기준으로 구분)하여 입력해주세요: ";
    public static final String INVALID_CAR_NAMES_ZERO_NAME_MESSAGE = "하나 이상의 자동차 이름을 쉼표로 구분하여 입력해주세요";
    public static final String INVALID_CAR_NAMES_ZERO_LENGTH_MESSAGE = "자동차의 이름은 1이상이어야 합니다";
    public static final String INVALID_CAR_NAMES_OVER_LENGTH_MESSAGE = "자동차 이름은 5자 이하여야 합니다";
    public static final String CAR_NAME_SPLITTER = ",";
    public static final int CAR_NAME_MAX_LENGTH = 5;

    public static String[] getCarNames(Scanner scanner) {
        System.out.println(INPUT_CAR_NAMES_MESSAGE);
        String stringNames = scanner.nextLine();
        String[] carNames = preprocessCarNames(stringNames);
        try {
            validateCarNames(carNames);
            return carNames;
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            return getCarNames(scanner);
        }
    }

    public static String[] preprocessCarNames(String stringNames) {
        String[] carNames = stringNames.split(CAR_NAME_SPLITTER);
        for (int i = 0; i < carNames.length; i++) {
            carNames[i] = carNames[i].trim();
        }
        return carNames;
    }

    public static int getGameRound(Scanner scanner) {
        System.out.println(INPUT_ROUND_MESSAGE);
        String gameRound = scanner.next();
        try {
            validateGameRound(gameRound);
            return Integer.parseInt(gameRound);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            return getGameRound(scanner);
        }
    }

    public static void validateGameRound(String gameRound) throws IllegalArgumentException {
        // 숫자가 아닌 값이 입력되면 예외 발생
        int intGameRound;
        try {
            intGameRound = Integer.parseInt(gameRound);
        } catch (Exception e) {
            throw new IllegalArgumentException(ERROR_PREFIX + INVALID_ROUND_INPUT_NOT_INTEGER_MESSAGE);
        }
        if (intGameRound < 1) {
            throw new IllegalArgumentException(ERROR_PREFIX + INVALID_ROUND_INPUT_SMALLER_THAN_ZERO_MESSAGE);
        }
    }

    public static void validateCarNames(String[] carNames) throws IllegalArgumentException {
        if (carNames.length == 0) {
            throw new IllegalArgumentException(ERROR_PREFIX + INVALID_CAR_NAMES_ZERO_NAME_MESSAGE);
        }
        for (String name : carNames) {
            if (name.length() == 0) {
                throw new IllegalArgumentException(ERROR_PREFIX + INVALID_CAR_NAMES_ZERO_LENGTH_MESSAGE);
            }
            if (name.length() > CAR_NAME_MAX_LENGTH) {
                throw new IllegalArgumentException(ERROR_PREFIX + INVALID_CAR_NAMES_OVER_LENGTH_MESSAGE);
            }
        }
    }
}