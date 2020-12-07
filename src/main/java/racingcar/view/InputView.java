package racingcar.view;

import utils.validator.InputValidator;

import java.util.Scanner;

public class InputView {
    private InputValidator inputValidator;
    private Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
        inputValidator = new InputValidator();
    }

    public String[] askCarName() {
        String inputNames = scanner.nextLine();
        return inputValidator.validNames(inputNames);
    }
}
