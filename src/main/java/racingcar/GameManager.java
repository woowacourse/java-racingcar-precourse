package racingcar;

import view.InputView;
import view.OutputView;

import java.util.Scanner;

public class GameManager {
    private Cars cars;

    public void createCar(Scanner scanner) {
        OutputView.printInputCarName();
        InputView.inputPlayerName(scanner);

        // cars = new Cars();
    }
}
