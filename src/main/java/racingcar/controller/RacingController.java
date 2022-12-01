package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class RacingController {

    private final InputView inputView;
    private final OutputView outputView;

    public RacingController() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void run() {
        List<String> carNames = inputView.readCarNames();
        List<Car> cars = carNames.stream().map(Car::new).collect(Collectors.toList());
        int trial = inputView.readGameTrial();

        RacingGame racingGame = new RacingGame(cars, trial);
        start(racingGame);
    }

    private void start(RacingGame racingGame) {
        int trial = 1;
        while (racingGame.canContinue(trial)) {
            racingGame.run();
            outputView.showResult(racingGame);
            trial++;
        }
        outputView.showWinners(racingGame);
    }
}