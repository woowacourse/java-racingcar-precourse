package racingcar;

import utils.RandomUtils;
import view.InputView;
import view.OutputView;

import java.util.Scanner;

public class GameManager {
    private static final int RANDOM_START_VALUE = 0;
    private static final int RANDOM_END_VALUE = 10;
    private static final int GO_FORWARD_VALUE = 4;

    private Cars cars;

    public void createCar(Scanner scanner) {
        OutputView.printInputCarName();

        cars = new Cars(InputView.inputPlayerName(scanner));
    }

    private boolean isGoForward() {
        return RandomUtils.nextInt(RANDOM_START_VALUE, RANDOM_END_VALUE) >= GO_FORWARD_VALUE;
    }
}
