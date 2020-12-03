package racingcar.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final String COMMA_DELIMITER = ",";

    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public List<String> inputCarNames() {
        String[] carNames = this.scanner.nextLine()
                .split(COMMA_DELIMITER);
        return Arrays.stream(carNames)
                .collect(Collectors.toList());
    }
}
