package racingcar;

import java.util.Scanner;

public class InputHandler {
    private static final String PLEASE_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String DELIMITER = ",";

    private Scanner scanner;

    public InputHandler(Scanner scanner) {
        this.scanner = scanner;
    }

    public String[] askCarNames() {
        System.out.println(PLEASE_INPUT_MESSAGE);
        String userInput = scanner.nextLine();
        return tryParseCarNames(userInput);
    }

    private String[] tryParseCarNames(String userInput) {
        try {
            return parseCarNames(userInput);
        } catch (Exception exception) {
            return askCarNames();
        }
    }

    private String[] parseCarNames(String userInput) {
        String[] carNames = userInput.split(DELIMITER);
        return carNames;
    }
}