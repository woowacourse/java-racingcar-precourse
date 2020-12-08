package racingcar;

import static racingcar.Messages.PLEASE_INPUT_NAMES_OF_CAR;
import static racingcar.Messages.PLEASE_INPUT_TURNS;
import static utils.PrintUtils.print;

import java.util.List;
import java.util.Scanner;

public class RacingGame {

    private final Scanner scanner;
    private List<Car> cars;
    private Integer turns;

    public RacingGame(Scanner scanner) {
        this.scanner = scanner;
    }

    public void play() {
        getReady();
        GameResult gameResult = Race.start(cars, turns);
        gameResult.printWinners();
    }

    private void getReady() {
        getCarsReady();
        getTryCountReady();
    }

    private void getCarsReady() {
        print(PLEASE_INPUT_NAMES_OF_CAR);
        CarsInputValidator carsInputValidator = new CarsInputValidator();
        while (!carsInputValidator.isValid()) {
            carsInputValidator.validate(getInput());
        }
        cars = carsInputValidator.getCars();
    }

    private void getTryCountReady() {
        print(PLEASE_INPUT_TURNS);
        TurnsInputValidator turnsInputValidator = new TurnsInputValidator();
        while (!turnsInputValidator.isValid()) {
            turnsInputValidator.validate(getInput());
        }
        turns = turnsInputValidator.getTurns();
    }

    private String getInput() {
        return scanner.nextLine();
    }
}
