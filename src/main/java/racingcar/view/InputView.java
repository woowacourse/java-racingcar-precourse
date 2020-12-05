package racingcar.view;

import java.util.Scanner;

public class InputView {
    private static final String NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String scanCarName() {
        printNameInputMessage();
        return scanUserInput();
    }

    private void printNameInputMessage() {
        System.out.println(NAME_INPUT_MESSAGE);
    }

    private String scanUserInput() {
        return this.scanner.nextLine();
    }
}