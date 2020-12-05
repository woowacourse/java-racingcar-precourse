package racingcar;

import view.InputView;
import view.OutputView;

import java.util.Scanner;

public class GameManager {
    private Cars cars;
    private int tryTimes;

    public void startRace(Scanner scanner) {
        createCar(scanner);

        cars.showRaceStateResultMessage();
        cars.doRace(tryTimes);
        cars.showRaceResult();
    }

    public void createCar(Scanner scanner) {
        initCar(scanner);
        initTryTimes(scanner);
    }

    private void initCar(Scanner scanner) {
        OutputView.printInputCarName();

        cars = new Cars(InputView.inputPlayerName(scanner));
    }

    private void initTryTimes(Scanner scanner) {
        OutputView.printInputRaceTime();

        tryTimes = InputView.inputTryTimes(scanner);
    }
}
