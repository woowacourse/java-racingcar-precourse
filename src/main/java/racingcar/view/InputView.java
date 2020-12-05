package racingcar.view;

import java.util.Scanner;

import static racingcar.constant.Constants.PLEASE_INPUT_CAR_NAME;
import static racingcar.constant.Constants.PLEASE_INPUT_NUMBER_OF_ATTEMPTS;

public class InputView {
    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String inputCarName() {
        System.out.println(PLEASE_INPUT_CAR_NAME);
        return scanner.nextLine();
    }

    public String inputNumberOfAttempts() {
        System.out.println(PLEASE_INPUT_NUMBER_OF_ATTEMPTS);
        return scanner.nextLine();
    }
}
