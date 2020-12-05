package racingcar;

import java.util.Scanner;

public class InputRound implements AcceptableRound {
    private int numberRounds; // 이동 횟수 = 라운드 수

    public int input(Scanner scanner) {
        validateRoundInput(inputNumberRounds(scanner));

        return numberRounds;
    }

    private static String inputNumberRounds(Scanner scanner) {
        System.out.println(MESSAGE_INPUT_NUMBER_ROUNDS);

        return scanner.nextLine();
    }

    private void validateRoundInput(String stringInputNumberRounds) {
        isNumber(stringInputNumberRounds);
        isNaturalNumber(numberRounds);
    }

    private void isNumber(String stringInputNumberRounds) {
        try {
            numberRounds = Integer.parseInt(stringInputNumberRounds);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(MESSAGE_ERROR_NOT_VALID_ROUND_NUMBER);
        }
    }

    private void isNaturalNumber(int numberRounds) {
        if (numberRounds < MINIMUM_NATURAL_NUMBER) {
            throw new IllegalArgumentException(MESSAGE_ERROR_NOT_VALID_ROUND_NUMBER);
        }
    }
}

