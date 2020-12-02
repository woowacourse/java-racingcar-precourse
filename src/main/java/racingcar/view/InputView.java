package racingcar.view;

import java.util.Scanner;
import racingcar.domain.race.exception.InvalidMovingCountInputException;

public final class InputView {

    private static final String ONLY_DIGIT_REGULAR = "^[0-9]*";

    private final Scanner scanner;

    private InputView(final Scanner scanner) {
        this.scanner = scanner;
    }

    public static InputView of(final Scanner scanner) {
        return new InputView(scanner);
    }

    public String readCarNames() {
        return scanner.nextLine();
    }

    public int readMovingCount() {
        String movingCountStr = scanner.nextLine();
        if (!isOnlyDigit(movingCountStr)) {
            throw new InvalidMovingCountInputException(movingCountStr);
        }

        return Integer.parseInt(movingCountStr);
    }

    private boolean isOnlyDigit(final String value) {
        return value.matches(ONLY_DIGIT_REGULAR);
    }
}
