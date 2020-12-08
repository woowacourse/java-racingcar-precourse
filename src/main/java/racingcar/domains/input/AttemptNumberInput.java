package racingcar.domains.input;

import racingcar.domains.error.RacingCarGameException;
import racingcar.domains.validate.Validator;
import racingcar.domains.validate.Validators;

import java.util.Scanner;

public class AttemptNumberInput implements Input<Integer> {

    Scanner scanner;
    String attemptNumber;

    public AttemptNumberInput(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public Integer get() throws RacingCarGameException {
        attemptNumber = scanner.nextLine();
        isValid();

        return Integer.parseInt(attemptNumber);
    }

    public void isValid() throws RacingCarGameException {
        Validator validator = Validators.getAttemptNumberInputValidator();
        validator.isValid(attemptNumber);
    }
}
