package racingcar;

import java.util.stream.Collectors;
import ui.Input;
import ui.Output;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {

    private List<Car> cars = new ArrayList<>();
    private AttemptsCount attemptsCount;

    public void start(Scanner scanner) {
        try {
            inputCarNamesAndSetCars(scanner);
            inputAttemptsCountAndSetAttemptsCount(scanner);
            completeAttempts();
            List<String> winners = getWinners();
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
        for (int i = 0; i < carNames.length; i++) {
            cars.add(new Car(carNames[i]));
        }
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
        attemptsCount = new AttemptsCount(attemptsCountInput);
    }

    private void validateCarNames(String[] carNames) {
        if (carNames.length == 0) {
            throw new IllegalArgumentException(ErrorMessage.SHOULD_BE_NOT_EMPTY_OR_COMMA_NAME);
        }
    }

    private void completeAttempts() {
        Output.willPrintResult();
        for (int i = 0; i < attemptsCount.getCount(); i++) {
            completeAttempt();
        }
    }

    private void completeAttempt() {
        moveCarsAndPrintResult();
        Output.printEmptyLine();
    }

    private void moveCarsAndPrintResult() {
        cars.stream().forEach(car -> car.moveAndPrintResult());
    }

    private List<String> getWinners() {
        int maxPosition = cars.stream()
            .map(car -> car.getPosition())
            .mapToInt(x -> x)
            .max()
            .getAsInt();
        return cars.stream()
            .filter(car -> car.getPosition() == maxPosition)
            .map(car -> car.getName())
            .collect(Collectors.toList());
    }
}
