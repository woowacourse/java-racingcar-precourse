package racingcar.domain;

import racingcar.view.OutputView;

public class RacingGameApplication {

    private final InputParser inputParser;
    private final OutputView outputView;

    public RacingGameApplication(InputParser inputParser, OutputView outputView) {
        this.inputParser = inputParser;
        this.outputView = outputView;
    }

    public void run() {
        RacingGame racingGame = createRacingGame();
        outputView.printRunMessage();
        runningGame(racingGame);
        outputView.printWinnerNames(racingGame.getWinners());
    }

    private RacingGame createRacingGame() {
        Cars cars = inputParser.createCars();
        CountOfMoves countOfMoves = inputParser.createCountOfMoves();
        return new RacingGame(cars, countOfMoves);
    }

    private void runningGame(RacingGame racingGame) {
        while (!racingGame.isOver()) {
            outputView.printCarsPosition(racingGame.move());
        }
    }
}
