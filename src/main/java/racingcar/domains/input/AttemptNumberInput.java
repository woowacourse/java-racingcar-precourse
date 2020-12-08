package racingcar.domains.input;

import racingcar.domains.error.RacingCarGameException;
import racingcar.domains.validate.AttemptNumberInputValidator;
import racingcar.domains.validate.Validator;

import java.util.Scanner;

public class AttemptNumberInput implements Input<Integer> {

    private static final String INPUT_MESSAGE = "시도할 회수는 몇회인가요?";

    private final Scanner scanner;
    private String attemptNumber;

    public AttemptNumberInput(final Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public Integer get() throws RacingCarGameException {
        printInputMessage();
        inputFromUser();
        isValid();

        return Integer.parseInt(attemptNumber);
    }

    private void printInputMessage() {
        System.out.println(INPUT_MESSAGE);
    }

    private void inputFromUser() {
        attemptNumber = scanner.nextLine();
    }

    private void isValid() throws RacingCarGameException {
        Validator<String> validator = new AttemptNumberInputValidator();
        validator.isValid(attemptNumber);
    }
}
