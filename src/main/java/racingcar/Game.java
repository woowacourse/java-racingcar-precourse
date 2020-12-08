package racingcar;

import ui.Input;
import ui.Output;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {

    private Cars cars;
    private Attempts attempts;

    public void start(Scanner scanner) {
        try {
            inputCarNamesAndSetCars(scanner);
            inputAttemptsCountAndSetAttemptsCount(scanner);
            attempts.completeAll(cars);
            List<String> winners = cars.getWinners();
            Output.printWinners(winners);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void inputCarNamesAndSetCars(Scanner scanner) {
        try {
            tryToInputCarNamesAndSetCars(scanner);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            inputCarNamesAndSetCars(scanner);
        }
    }

    private void tryToInputCarNamesAndSetCars(Scanner scanner) {
        String carNamesInput = Input.receiveRacingCarNames(scanner);
        Input.validateEmpty(carNamesInput);
        String[] carNames = carNamesInput.split(",");
        validateCarNames(carNames);
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carNames.length; i++) {
            cars.add(new Car(carNames[i]));
        }
        this.cars = new Cars(cars);
    }

    private void inputAttemptsCountAndSetAttemptsCount(Scanner scanner) {
        try {
            tryToInputAttemptsCountAndSetAttemptsCount(scanner);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            inputAttemptsCountAndSetAttemptsCount(scanner);
        }
    }

    private void tryToInputAttemptsCountAndSetAttemptsCount(Scanner scanner) {
        String attemptsCountInput = Input.receiveAttemptsCount(scanner);
        Input.validateEmpty(attemptsCountInput);
        attempts = new Attempts(attemptsCountInput);
    }

    private void validateCarNames(String[] carNames) {
        if (carNames.length == 0) {
            throw new IllegalArgumentException(ErrorMessage.SHOULD_BE_NOT_EMPTY_OR_COMMA_NAME);
        }
    }
}
