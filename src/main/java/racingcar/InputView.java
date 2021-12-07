package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String[] inputCarNames() {
        System.out.println(RacingCarConstant.INPUT_CAR_NAMES_MESSAGE);
        while (true) {
            String[] carNames = Console.readLine().split(RacingCarConstant.DELIMITER);
            try {
                InputValidator.validateCarNamesInput(carNames);
                return carNames;
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    public static int inputAttempt() {
        System.out.println(RacingCarConstant.INPUT_ATTEMPT_MESSAGE);
        while (true) {
            String attempt = Console.readLine();
            try {
                InputValidator.validateTryNumber(attempt);
                return Integer.parseInt(attempt);
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

}
