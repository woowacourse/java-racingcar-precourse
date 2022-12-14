package racingcar.controller;

import java.util.List;
import racingcar.controller.util.ExceptionHandler;
import racingcar.dto.CarStatusDTO;
import racingcar.model.RacingGame;
import racingcar.model.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final RacingGame racingGame = new RacingGame(new RandomNumberGenerator());

    public void run() {
        executeFunction(this::enrollCarToRace);
        executeFunction(this::moveCarsByCount);
        executeFunction(this::showWinners);
    }

    private void executeFunction(Runnable runnable) {
        ExceptionHandler.retryForIllegalArgument(runnable, outputView::printErrorMessage);
    }

    private void enrollCarToRace() {
        List<String> carNames = inputView.inputCarNames();
        racingGame.enrollCars(carNames);
    }

    private void moveCarsByCount() {
        int moveCount = inputView.inputMoveCount();
        List<CarStatusDTO> carStatuses = racingGame.repeatMovingCars(moveCount);
        outputView.printGameResult(carStatuses);
    }

    private void showWinners() {
        List<String> winnerNames = racingGame.findWinners();
        outputView.printWinners(winnerNames);
    }
}
