package racingcar.domains.Game;

import racingcar.domains.car.Cars;
import racingcar.domains.error.RacingCarGameException;
import racingcar.domains.input.AttemptNumberInput;
import racingcar.domains.input.CarNamesInput;

import java.util.List;
import java.util.Scanner;

public class Game {
    private static final String EXECUTION_RESULT_MESSAGE = "\n실행 결과";

    private final Scanner scanner;
    private Cars cars;
    private List<String> carNames;
    private Integer attemptNumber;

    public Game(final Scanner scanner) {
        this.scanner = scanner;
    }

    public void run() {
        try {
            getCarNamesFromUser();
            getAttemptNumberFromUser();
            getCars();

            moveCarsAndPrint();

            printResult();
        } catch (RacingCarGameException e) {
            System.out.println(e.getMessage());
        }
    }

    private void getCarNamesFromUser() throws RacingCarGameException {
        CarNamesInput carNamesInput = new CarNamesInput(scanner);
        carNames = carNamesInput.get();
    }

    private void getAttemptNumberFromUser() throws RacingCarGameException {
        AttemptNumberInput attemptNumberInput = new AttemptNumberInput(scanner);
        attemptNumber = attemptNumberInput.get();
    }

    private void getCars() {
        cars = Cars.getInstanceWithCarNames(carNames);
    }

    private void moveCarsAndPrint() {
        System.out.println(EXECUTION_RESULT_MESSAGE);
        for (int i = 0; i < attemptNumber; i++) {
            cars.move();
            cars.getGameStatus().print();
        }
    }

    private void printResult() {
        cars.getGameResult().print();
    }
}
