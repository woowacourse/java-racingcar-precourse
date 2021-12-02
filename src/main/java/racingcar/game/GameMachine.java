package racingcar.game;

import java.util.List;

import racingcar.car.Cars;
import racingcar.car.MovingPolicy;
import racingcar.view.InputView;

public class GameMachine {
    private static final int ZERO_INDEX = 0;
    private static final String END_MESSAGE = "최종 우승자 : ";

    private final MovingPolicy movingPolicy;
    private final InputView inputView;

    public GameMachine(MovingPolicy movingPolicy, InputView inputView) {
        this.movingPolicy = movingPolicy;
        this.inputView = inputView;
    }

    public void run() {
        List<String> names = inputView.getNames();
        int tryCount = inputView.getTryCount();
        System.out.println();

        Cars cars = new Cars(names, movingPolicy);

        while (tryCount-- > ZERO_INDEX) {
            cars.move();
            System.out.println(cars.getExecutionResult());
            System.out.println();
        }

        System.out.println(END_MESSAGE + cars.getWinnersNames());
    }
}