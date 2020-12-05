package racingcar;

import static racingcar.Message.INPUT_COUNT_MESSAGE;
import static racingcar.Message.INPUT_NAME_MESSAGE;

import java.util.Scanner;

/**
 * @author yhh1056
 * @since 2020/12/02
 */
public class Input {
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

    public void showInputCountMessage() {
        print(INPUT_COUNT_MESSAGE);
    }

    private void print(String message) {
        System.out.println(message);
    }
}
