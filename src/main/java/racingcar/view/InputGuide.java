package racingcar.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import racingcar.exception.RacingCarErrorException;
import utils.ValidateUtils;

/**
 * 입력값을 받는 클래스
 */
public class InputGuide {

    private static final String CAR_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)";
    private static final String MOVES_INPUT_MESSAGE = "시도할 횟수는 몇회인가요? : ";
    private static final String DELIMITER = ",";

    private final ValidateUtils validateUtils;
    private final Scanner scanner;

    public InputGuide(Scanner scanner) {
        this.scanner = scanner;
        validateUtils = new ValidateUtils(scanner);
    }

    public List<String> inputCars() {
        System.out.println(CAR_INPUT_MESSAGE);
        String[] cars = splitCarNames(scanner.nextLine());
        try {
            validateUtils.isValid(cars);
            return Arrays.asList(cars);
        } catch (RacingCarErrorException exception) {
            System.out.println(exception.getMessage());
            return inputCars();
        }
    }

    private String[] splitCarNames(String input) {
        return input.split(DELIMITER);
    }

    public int countMove() {
        System.out.println(MOVES_INPUT_MESSAGE);
        try {
            return validateUtils.isMoreThanZero();
        } catch (RacingCarErrorException exception) {
            System.out.println(exception.getMessage());
            return countMove();
        }
    }
}
