package racingcar.domains.input;

import java.util.List;
import java.util.Scanner;

public class Inputs {
    public static Input<Integer> getAttemptNumberInput(Scanner scanner) {
        return new AttemptNumberInput(scanner);
    }

    public static Input<List<String>> getCarNamesInput(Scanner scanner) {
        return new CarNamesInput(scanner);
    }
}
