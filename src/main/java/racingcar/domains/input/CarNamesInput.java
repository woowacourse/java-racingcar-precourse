package racingcar.domains.input;

import racingcar.domains.error.RacingCarGameException;
import racingcar.domains.validate.Validator;
import racingcar.domains.validate.Validators;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CarNamesInput implements Input<List<String>> {

    private static final String DELIMITER = ",";

    private Scanner scanner;
    private String carNames;

    public CarNamesInput(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public List<String> get() throws RacingCarGameException {
        carNames = scanner.nextLine();
        isValid();
        return toList();
    }

    private void isValid() throws RacingCarGameException {
        Validator validator = Validators.getCarNameInputValidator();
        validator.isValid(carNames);
    }

    private List<String> toList() {
        String[] splitCarNames = carNames.split(DELIMITER);
        return Arrays.asList(splitCarNames);
    }
}
