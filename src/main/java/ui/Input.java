package ui;

import java.util.Scanner;
import racingcar.ErrorMessage;

public class Input {

    public static String receiveRacingCarNames(Scanner scanner) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return scanner.nextLine();
    }

    public static String receiveAttemptsCount(Scanner scanner) {
        System.out.println("시도할 회수는 몇회인가요?");
        return scanner.nextLine();
    }

    public static void validateEmpty(String input) {
        if (input == "") {
            throw new IllegalArgumentException(ErrorMessage.SHOULD_NOT_INPUT_EMPTY);
        }
    }
}