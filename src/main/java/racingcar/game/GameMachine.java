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
        List<String> names = inputView.getNames();
        int tryCount = inputView.getTryCount();
        System.out.println();

        Cars cars = new Cars(names, movingPolicy);

        while (tryCount-- > ZERO_INDEX) {
            cars.move();
            outputView.printExecutionResult(cars.getExecutionResult());
        }

        outputView.printWinnerNames(cars.getWinnersNames());
    }
}