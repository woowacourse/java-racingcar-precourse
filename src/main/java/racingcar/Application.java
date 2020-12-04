package racingcar;

import view.InputView;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        Cars cars = InputView.getNames(scanner);
        Rounds rounds = InputView.getRounds(scanner);

        RacingGame racingGame = new RacingGame(cars, rounds);
        racingGame.play();
    }
}
