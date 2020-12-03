package racingcar.view;

import java.util.List;
import java.util.Scanner;
import racingcar.controller.RacingCarErrorException;
import racingcar.model.Car;
import utils.ValidUtils;

/**
 * 입력값을 받는 클래스
 */
public class InputGuide {

    private static final String CAR_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)";
    private static final String MOVES_INPUT_MESSAGE = "시도할 횟수는 몇회인가요? : ";
    private static final String REST = ",";
    private final ValidUtils validUtils;
    private final Scanner scanner;

    public InputGuide(Scanner scanner) {
        this.scanner = scanner;
        validUtils = new ValidUtils(scanner);
    }

    public List<Car> inputCars() {
        System.out.println(CAR_INPUT_MESSAGE);
        String[] cars = splitCarsName(scanner.nextLine());
        try {
            return validUtils.isValid(cars);
        } catch (RacingCarErrorException exception) {
            System.out.println(exception.getMessage());
            return inputCars();
        }
    }

    private String[] splitCarsName(String input) {
        return input.split(REST);
    }

    public int countMove() {
        System.out.println(MOVES_INPUT_MESSAGE);
        try {
            return validUtils.moreThanZero();
        } catch (RacingCarErrorException exception) {
            System.out.println(exception.getMessage());
            return countMove();
        }
    }
}
