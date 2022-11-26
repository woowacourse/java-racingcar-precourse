package racingcar.domain;

import racingcar.view.OutputView;

public class RacingGameApplication {

    private final RacingGameGenerator racingGameGenerator;
    private final OutputView outputView;

    public RacingGameApplication(RacingGameGenerator racingGameGenerator, OutputView outputView) {
        this.racingGameGenerator = racingGameGenerator;
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
            outputView.printCarsPosition(racingGame.move());
        }
    }
}
