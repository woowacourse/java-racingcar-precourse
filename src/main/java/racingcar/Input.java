package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Input {
    private static final String SEPARATOR = ",";
    private static final String CAR_NAMES_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ROUND_NUMBER_INPUT_MESSAGE = "시도할 회수는 몇회인가요?";

    private Scanner scanner;

    public Input(Scanner scanner) {
        this.scanner = scanner;
    }

    public List<String> createCarNames() {
        System.out.println(CAR_NAMES_INPUT_MESSAGE);
        String carNames = scanner.nextLine().trim();
        return splitCarNamesByComma(carNames);
    }

    public int createRoundNumber(){
        System.out.println(ROUND_NUMBER_INPUT_MESSAGE);
        String roundNumber = scanner.nextLine();
        Validator.validateRoundNumber(roundNumber);
        return Integer.parseInt(roundNumber);
    }

    private List<String> splitCarNamesByComma(String carNames) {
        List<String> splittedCarNames = Arrays.asList(carNames.split(SEPARATOR));
        Validator.validateCarNames(splittedCarNames);
        return splittedCarNames;
    }
}
