package racingcar.game;

import java.util.List;

import racingcar.car.Cars;
import racingcar.car.MovingPolicy;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameMachine {
    private static final int ZERO_INDEX = 0;

    private final MovingPolicy movingPolicy;
    private final InputView inputView;
    private final OutputView outputView;

    public GameMachine(MovingPolicy movingPolicy, InputView inputView, OutputView outputView) {
        this.movingPolicy = movingPolicy;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        Cars cars = getCars();
        int tryCount = getTryCount();
        System.out.println();

        repeat(cars, tryCount);
    }

    private Cars getCars() {
        List<String> names = inputView.getNames();
        try {
            return new Cars(names, movingPolicy);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return getCars();
        }
    }

    private int getTryCount() {
        try {
            return inputView.getTryCount();
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return getTryCount();
        }
    }

    private void repeat(Cars cars, int tryCount) {
        while (tryCount-- > ZERO_INDEX) {
            cars.move();
            outputView.printExecutionResult(cars.getExecutionResult());
        }
        outputView.printWinnerNames(cars.getWinnersNames());
    }
}