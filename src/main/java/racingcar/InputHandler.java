package racingcar;

import java.util.Scanner;

public class InputHandler {
    private static final String PLEASE_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ASK_MOVE_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";
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
            InputExceptionHandler.validateCarNames(userInput, DELIMITER);
            String[] carNames = userInput.split(DELIMITER);
            return carNames;
        } catch (Exception exception) {
            return askCarNames();
        }
    }

    public int askMoveCount() {
        System.out.println(ASK_MOVE_COUNT_MESSAGE);
        String userInput = scanner.nextLine();
        return tryParseMoveCount(userInput);
    }

    private int tryParseMoveCount(String userInput) {
        try {
            InputExceptionHandler.validateMoveCount(userInput);
            int moveCount = Integer.parseInt(userInput);
            return moveCount;
        } catch (Exception exception) {
            return askMoveCount();
        }
    }
}