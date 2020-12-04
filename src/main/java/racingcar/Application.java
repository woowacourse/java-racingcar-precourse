package racingcar;

import racingcar.domain.car.Cars;
import racingcar.domain.car.DefaultCarMovement;
import racingcar.domain.racinggame.RacingGame;
import racingcar.domain.trynumber.TryNumber;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        Cars cars = InputView.inputCarNames(scanner);
        TryNumber tryNumber = InputView.inputTryNumber(scanner);

        RacingGame racingGame = new RacingGame(cars, tryNumber);
        OutputView.printProcess(racingGame.play(new DefaultCarMovement()));
        OutputView.printWinners(racingGame.findWinners());
    }
}
