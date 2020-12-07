package racingcar.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final String COMMA = ",";

    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public List<String> inputCarNames() {
        String carNames = scanner.nextLine();

        return Arrays.stream(carNames.split(COMMA))
                .map(s -> s.trim())
                .collect(Collectors.toList());
    }

    public String inputAttemptNumber() {
        return scanner.nextLine();
    }
}

