package racingcar.controller;

import racingcar.controller.input.InputController;
import racingcar.controller.view.ConsoleView;
import racingcar.controller.view.ViewController;
import racingcar.domain.Racing;
import racingcar.domain.car.Car;

import java.util.List;
import java.util.Scanner;

public class Game {

    private final InputController inputController;
    private final ViewController viewController;
    private Racing racing;
    private static int repeatCount;

    public Game(Scanner scanner) {
        this.inputController = new InputController(scanner);
        this.viewController = new ConsoleView();
    }

    public Game(Scanner scanner, ViewController viewController) {
        this.inputController = new InputController(scanner);
        this.viewController = viewController;
    }

    public void start() {

        setRacing();
        setRepeatCount();

        race();

        printResult();
    }

    private void setRepeatCount() {
        repeatCount = inputController.inputRepeatCount();
    }

    private void setRacing() {
        String[] names = inputController.inputNames();
        this.racing = Racing.create(names);
    }

    private void race() {

        while (hasMoreTurn()) {
            nextTurn();
        }

        resultToViewer();
    }

    private void resultToViewer() {
        List<Car> winners = racing.getWinners();
        viewController.recordWinner(winners);
    }

    private boolean hasMoreTurn() {
        if (repeatCount == 0) {
            return false;
        }
        return true;
    }

    private void nextTurn() {
        repeatCount--;
        racing.moveCars();
        viewController.recordCarsPosition(racing.toString());
    }

    private void printResult() {
        viewController.printResult();
    }


}
