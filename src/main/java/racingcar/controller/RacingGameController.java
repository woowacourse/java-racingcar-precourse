package racingcar.controller;

import racingcar.domain.car.Cars;
import racingcar.domain.dto.CarDto;
import racingcar.domain.game.GameState;
import racingcar.domain.game.RacingGame;
import racingcar.domain.strategy.MovingStrategy;
import racingcar.domain.strategy.RandomMovingStrategy;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingGameController {

    private final InputView inputView;

    public RacingGameController(InputView inputView) {
        this.inputView = inputView;
    }

    public void run() {
        List<String> carNames = this.inputView.inputCarNames();
        int racingTryCounts = this.inputView.inputRacingTryCounts();
        MovingStrategy movingStrategy = new RandomMovingStrategy();
        Cars racingCars = Cars.createCars(carNames, movingStrategy);
        GameState gameState = GameState.initiate(racingTryCounts);
        RacingGame racingGame = new RacingGame(racingCars, gameState);
        startRacingGame(racingGame);
    }

    private void startRacingGame(RacingGame racingGame) {
        OutputView.printGameExecutionResultHeader();
        while (!racingGame.isEnd()) {
            racingGame.race();
            List<CarDto> racingCarDtos = racingGame.getCarDtos();
            OutputView.printRacingTryResult(racingCarDtos);
        }
        List<String> winnerCarNames = racingGame.getWinnerCarNames();
        OutputView.printWinnerCarNames(winnerCarNames);
    }
}
