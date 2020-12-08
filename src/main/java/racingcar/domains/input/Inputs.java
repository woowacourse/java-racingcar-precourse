package racingcar.domains.input;

import java.util.Scanner;

public class Inputs {
    public static Input getAttemptNumberInput(Scanner scanner) {
        return new AttemptNumberInput(scanner);
    }

    public static Input getCarNamesInput(Scanner scanner) {
        return new CarNamesInput(scanner);
    }
}
