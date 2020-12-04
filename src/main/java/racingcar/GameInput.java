package racingcar;

import java.util.Scanner;

public class GameInput {
    public static String[] getCarNames(Scanner scanner) {
        System.out.println(GameConstants.INPUT_CAR_NAMES_MESSAGE);
        String stringNames = scanner.nextLine();
        String[] carNames = stringNames.split(",");
        try {
            validateCarNames(carNames);
            return carNames;
        } catch (IllegalArgumentException e) {
            System.out.println(GameConstants.INVALID_CAR_NAMES_MESSAGE);
            return getCarNames(scanner);
        }
    }

    public static int getGameRound(Scanner scanner) {
        System.out.println(GameConstants.INPUT_ROUND_MESSAGE);
        String gameRound = scanner.next();
        try {
            validateGameRound(gameRound);
            return Integer.parseInt(gameRound);
        } catch (IllegalArgumentException e) {
            System.out.println(GameConstants.INVALID_ROUND_INPUT_MESSAGE);
            return getGameRound(scanner);
        }
    }

    public static boolean validateGameRound(String gameRound) throws IllegalArgumentException {
        // 숫자가 아닌 값이 입력되면 예외 발생
        for (int i = 0; i < gameRound.length(); i++) {
            if (!Character.isDigit(gameRound.charAt(i))) {
                throw new IllegalArgumentException();
            }
        }
        if (Integer.parseInt(gameRound) < 1) {
            throw new IllegalArgumentException();
        }
        return true;
    }

    public static boolean validateCarNames(String[] carNames) throws IllegalArgumentException {
        if (carNames.length == 0) {
            throw new IllegalArgumentException();
        }
        for(String name : carNames) {
            if (name.length() == 0) {
                throw new IllegalArgumentException();
            }
        }
        return true;
    }
}
