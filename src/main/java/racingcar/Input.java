package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Input {
    private static final String SEPARATOR = ",";

    private Scanner scanner;

    public Input(Scanner scanner) {
        this.scanner = scanner;
    }

    public List<String> createCarNames() {
        String carNames = scanner.nextLine().trim();
        return splitCarNamesByComma(carNames);
    }

    public int createRoundNumber(){
        String roundNumber = scanner.nextLine();
        return Integer.parseInt(roundNumber);
    }

    private List<String> splitCarNamesByComma(String carNames) {
        List<String> splittedCarNames = Arrays.asList(carNames.split(SEPARATOR));
        Validator.validateCarNames(splittedCarNames);
        return splittedCarNames;
    }
}
