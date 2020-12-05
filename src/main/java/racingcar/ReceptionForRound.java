package racingcar;

import java.util.Scanner;

public class ReceptionForRound {
    private int numberTryToMove; // 이동 횟수 = 라운드 수

    private static final int MINIMUM_NATURAL_NUMBER = 1;
    private static final String MESSAGE_INPUT_NUMBER_TRY_TO_MOVE = "시도할 횟수는 몇 회인가요?";
    private static final String MESSAGE_ERROR_NOT_VALID_TRY_NUMBER = "[ERROR] 시도 횟수는 1 이상의 자연수여야 합니다.";

    public int input(Scanner scanner) {
        validateRoundInput(inputNumberTryToMove(scanner));

        return numberTryToMove;
    }

    private static String inputNumberTryToMove(Scanner scanner) {
        System.out.println(MESSAGE_INPUT_NUMBER_TRY_TO_MOVE);

        return scanner.nextLine();
    }

    private void validateRoundInput(String stringInputTryNumber) {
        isNumber(stringInputTryNumber);
        isNaturalNumber(numberTryToMove);
    }

    private void isNumber(String stringInputTryNumber) {
        try {
            numberTryToMove = Integer.parseInt(stringInputTryNumber);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(MESSAGE_ERROR_NOT_VALID_TRY_NUMBER);
        }
    }

    private void isNaturalNumber(int numberTryToMove) {
        if (numberTryToMove < MINIMUM_NATURAL_NUMBER) {
            throw new IllegalArgumentException(MESSAGE_ERROR_NOT_VALID_TRY_NUMBER);
        }
    }
}

