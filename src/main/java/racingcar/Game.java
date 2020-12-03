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
            setCars(scanner);
            setAttemptsCount(scanner);
            completeAttempts();
            List<String> winners = getWinners();
            Output.printWinners(winners);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void setCars(Scanner scanner) {
        try {
            tryToSetCars(scanner);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            setCars(scanner);
        }
    }

    private void tryToSetCars(Scanner scanner) {
        String carNamesInput = Input.receiveRacingCarNames(scanner);
        Input.validateEmpty(carNamesInput);
        String[] carNames = carNamesInput.split(",");
        validateCarNames(carNames);
        for (int i = 0; i < carNames.length; i++) {
            cars.add(new Car(carNames[i]));
        }
    }

    private void setAttemptsCount(Scanner scanner) {
        try {
            tryToSetAttemptsCount(scanner);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            setAttemptsCount(scanner);
        }
    }

    private void tryToSetAttemptsCount(Scanner scanner) {
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
        cars.stream().forEach(car -> car.move());
        Output.printEmptyLine();
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
