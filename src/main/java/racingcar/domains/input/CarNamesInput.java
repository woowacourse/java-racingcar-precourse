package racingcar.domains.input;

import racingcar.domains.error.RacingCarGameException;
import racingcar.domains.validate.CarNamesInputValidator;
import racingcar.domains.validate.Validator;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CarNamesInput implements Input<List<String>> {

    private static final String INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String DELIMITER = ",";

    private final Scanner scanner;
    private String carNames;

    public CarNamesInput(final Scanner scanner) {
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
        Validator<String> validator = new CarNamesInputValidator();
        validator.isValid(carNames);
    }

    private List<String> toList() {
        String[] splitCarNames = carNames.split(DELIMITER);
        return Arrays.stream(splitCarNames)
                .map(String::trim)
                .collect(Collectors.toList());
    }
}
