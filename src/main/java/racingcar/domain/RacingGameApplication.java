package racingcar.domain;

import racingcar.NumberGenerator;
import racingcar.view.OutputView;

public class RacingGameApplication {

    private final RacingGameGenerator racingGameGenerator;
    private final NumberGenerator numberGenerator;
    private final OutputView outputView;

    public RacingGameApplication(RacingGameGenerator racingGameGenerator,
                                 NumberGenerator numberGenerator,
                                 OutputView outputView) {
        this.racingGameGenerator = racingGameGenerator;
        this.numberGenerator = numberGenerator;
        this.outputView = outputView;
    }

    public void run() {
        RacingGame racingGame = createRacingGame();
        outputView.printRunMessage();
        runningGame(racingGame);
        outputView.printWinnerNames(racingGame.getWinners());
    }

    private RacingGame createRacingGame() {
        Cars cars = racingGameGenerator.createCars();
        CountOfMoves countOfMoves = racingGameGenerator.createCountOfMoves();
        return new RacingGame(cars, countOfMoves);
    }

    private void runningGame(RacingGame racingGame) {
        while (!racingGame.isOver()) {
            outputView.printCarsPosition(racingGame.move(numberGenerator));
        }
    }
}
