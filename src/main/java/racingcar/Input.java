package racingcar;

import java.util.Scanner;

/**
 * @author yhh1056
 * @since 2020/12/02
 */
public class Input {
    public static final String INPUT_NAME_MESSAGE =
            "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final Scanner scanner;

    public Input(Scanner scanner) {
        this.scanner = scanner;
    }

    public String nextLine() {
        return scanner.nextLine();
    }

    public void showInputNameMessage() {
        print(INPUT_NAME_MESSAGE);
    }

    private void print(String message) {
        System.out.println(message);
    }
}
