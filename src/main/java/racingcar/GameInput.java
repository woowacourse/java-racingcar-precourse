package racingcar;

import java.util.Scanner;

public class GameInput {
    public static String[] getCarNames(Scanner scanner) {
        System.out.println(GameConstants.INPUT_CAR_NAMES_MESSAGE);
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
        String[] carNames = stringNames.split(GameConstants.CAR_NAME_SPLITTER);
        for (int i = 0; i < carNames.length; i++) {
            carNames[i] = carNames[i].trim();
        }
        return carNames;
    }

    public static int getGameRound(Scanner scanner) {
        System.out.println(GameConstants.INPUT_ROUND_MESSAGE);
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
        for (int i = 0; i < gameRound.length(); i++) {
            if (!Character.isDigit(gameRound.charAt(i))) {
                throw new IllegalArgumentException(GameConstants.INVALID_ROUND_INPUT_NOT_INTEGER_MESSAGE);
            }
        }
        if (Integer.parseInt(gameRound) < 1) {
            throw new IllegalArgumentException(GameConstants.INVALID_ROUND_INPUT_SMALLER_THAN_ZERO_MESSAGE);
        }
    }

    public static void validateCarNames(String[] carNames) throws IllegalArgumentException {
        if (carNames.length == 0) {
            throw new IllegalArgumentException(GameConstants.INVALID_CAR_NAMES_ZERO_NAME_MESSAGE);
        }
        for (String name : carNames) {
            if (name.length() == 0) {
                throw new IllegalArgumentException(GameConstants.INVALID_CAR_NAMES_ZERO_LENGTH_MESSAGE);
            }
            if (name.length() > GameConstants.CAR_NAME_MAX_LENGTH) {
                throw new IllegalArgumentException(GameConstants.INVALID_CAR_NAMES_OVER_LENGTH_MESSAGE);
            }
        }
    }
}