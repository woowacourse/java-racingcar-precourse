package racingcar;

import view.InputView;
import view.OutputView;

import java.util.Scanner;

public class GameManager {
    private Cars cars;

    public void createCar(Scanner scanner) {
        OutputView.printInputCarName();

        cars = new Cars(InputView.inputPlayerName(scanner));
    }
}
