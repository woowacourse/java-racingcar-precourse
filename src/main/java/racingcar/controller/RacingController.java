package racingcar.controller;

import java.util.List;
import racingcar.model.RacingGame;
import racingcar.model.RandomNumberGenerator;
import racingcar.view.InputView;

public class RacingController {
    private static final InputView inputView = new InputView();
    private static final RacingGame racingGame = new RacingGame(new RandomNumberGenerator());

    public void run() {
        enrollCarToRace();
        moveCarsByCount();
    }

    public void enrollCarToRace() {
        List<String> carNames = inputView.inputCarNames();
        racingGame.enrollCars(carNames);
    }

    public void moveCarsByCount() {
        int moveCount = inputView.inputMoveCount();
        // TODO moveCount 만큼 반복 이동
    }
}
