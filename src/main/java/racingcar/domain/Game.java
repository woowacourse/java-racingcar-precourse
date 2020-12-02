package racingcar.domain;

import racingcar.view.InputView;

import java.util.Scanner;

public class Game {
    public static void run(Scanner scanner) {
        String[] names = InputView.getNames(scanner);
        Trial trial = InputView.getTrials(scanner);

        Cars cars = new Cars(names);
    }
}
