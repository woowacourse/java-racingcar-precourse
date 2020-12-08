package racingcar.domains.input;

import racingcar.domains.error.RacingCarGameException;
import racingcar.domains.validate.Validator;
import racingcar.domains.validate.Validators;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CarNamesInput implements Input<List<String>> {

    private static final String INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String DELIMITER = ",";

    private Scanner scanner;
    private String carNames;

    public CarNamesInput(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public List<String> get() throws RacingCarGameException {
        printInputMessage();
        inputFromUser();
        isValid();

        return toList();
    }

    private void printInputMessage() {
        System.out.println(INPUT_MESSAGE);
    }

    private void inputFromUser() {
        carNames = scanner.nextLine();
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
