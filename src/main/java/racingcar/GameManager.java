package racingcar;

import view.InputView;
import view.OutputView;

import java.util.Scanner;

public class GameManager {
    private Cars cars;
    private int tryTimes;

    public void createCar(Scanner scanner) {
        OutputView.printInputCarName();

        cars = new Cars(InputView.inputPlayerName(scanner));
        makeTryTimes(scanner);
    }

    private void makeTryTimes(Scanner scanner) {
        OutputView.printInputRaceTime();

        tryTimes = InputView.inputTryTimes(scanner);
    }
}
