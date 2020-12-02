package racingcar;

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
}
