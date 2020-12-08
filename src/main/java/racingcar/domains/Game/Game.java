package racingcar.domains.Game;

import racingcar.domains.car.Cars;
import racingcar.domains.error.RacingCarGameException;
import racingcar.domains.input.Inputs;

import java.util.List;
import java.util.Scanner;

public class Game {
    private Scanner scanner;
    private Cars cars;
    private List<String> carNames;
    private Integer attemptNumber;

    public Game(Scanner scanner) {
        this.scanner = scanner;
    }

    public void run() throws RacingCarGameException {
        getCarNamesFromUser();
        getAttemptNumberFromUser();
        getCars();

        moveCarsAndPrint();

        printResult();
    }

    private void getCarNamesFromUser() throws RacingCarGameException {
        carNames = Inputs.getCarNamesInput(scanner).get();
    }

    private void getAttemptNumberFromUser() throws RacingCarGameException {
        attemptNumber = Inputs.getAttemptNumberInput(scanner).get();
    }

    private void getCars() {
        cars = Cars.getInstanceWithCarNames(carNames);
    }

    private void moveCarsAndPrint() {
        for (int i = 0; i < attemptNumber; i++) {
            cars.move();
            cars.getGameStatus().print();
        }
    }

    private void printResult() {
        cars.getGameResult().print();
    }
}
