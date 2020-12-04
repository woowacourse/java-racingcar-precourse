package racingcar;

import java.util.Scanner;

public class InputHandler {
    private static final String REQUEST_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String REQUEST_MOVE_COUNT = "시도할 회수는 몇회인가요?";
    private static final String SEPARATOR = ",";

    private Scanner scanner;

    public InputHandler(Scanner scanner) {
        this.scanner = scanner;
    }

    public String[] askCarNames() {
        System.out.println(REQUEST_CAR_NAME);
        String userInput = getInput();
        return tryParseCarNames(userInput);
    }

    private String[] tryParseCarNames(String userInput) {
        try {
            InputExceptionHandler.validateCarNames(userInput, SEPARATOR);
            String[] carNames = getCarNames(userInput);
            InputExceptionHandler.validateCarNamesArray(carNames);
            return carNames;
        } catch (Exception exception) {
            return askCarNames();
        }
    }

    public int askMoveCount() {
        System.out.println(REQUEST_MOVE_COUNT);
        String userInput = getInput();
        return tryParseMoveCount(userInput);
    }

    private int tryParseMoveCount(String userInput) {
        try {
            InputExceptionHandler.validateMoveCount(userInput);
            return getMoveCount(userInput);
        } catch (Exception exception) {
            return askMoveCount();
        }
    }

    private String getInput() {
        return scanner.nextLine();
    }

    private String[] getCarNames(String userInput) {
        return userInput.split(SEPARATOR);
    }

    private int getMoveCount(String userInput) {
        return Integer.parseInt(userInput);
    }
}