package racingcar;

import java.util.Scanner;

public interface AcceptableRound {
    int MINIMUM_NATURAL_NUMBER = 1;
    String MESSAGE_INPUT_NUMBER_TRY_TO_MOVE = "시도할 횟수는 몇 회인가요?";
    String MESSAGE_ERROR_NOT_VALID_TRY_NUMBER = "[ERROR] 시도(라운드) 횟수는 1 이상의 자연수여야 합니다.";

    int input(Scanner scanner);
}
