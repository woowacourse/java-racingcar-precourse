package racingcar;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class InputView {
    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public Stream<String> getCarNames(){
        return Arrays.stream(scanner.nextLine().split(","));
    }

    public int getRoundNumber() {
        return scanner.nextInt();
    }
}
