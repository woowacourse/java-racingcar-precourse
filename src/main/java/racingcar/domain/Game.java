package racingcar.domain;

import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.Scanner;

public class Game {
    public static void run(Scanner scanner) {
        String[] names = InputView.getNames(scanner);
        Trial trial = InputView.getTrials(scanner);

        Cars cars = new Cars(names);

        OutputView.showResultHeader();
        for (int i = 0; i < trial.getTrial(); i++) {
            cars.moveCars();
            OutputView.printCurrentResult(cars.getCurrentResult());
        }

        OutputView.showWinnerHeader();
        OutputView.printWinner(cars.getMaxResult(cars.getMaxPosition()));
    }
}
