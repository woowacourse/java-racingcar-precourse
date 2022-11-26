package racingcar.domain;

import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameApplication {

    private final InputView inputView;
    private final InputParser inputParser;
    private final OutputView outputView;

    public RacingGameApplication(InputView inputView, InputParser inputParser, OutputView outputView) {
        this.inputView = inputView;
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
        Cars cars = inputParser.createCars(inputView);
        CountOfMoves countOfMoves = inputParser.createCountOfMoves(inputView);
        return new RacingGame(cars, countOfMoves);
    }

    private void runningGame(RacingGame racingGame) {
        while (!racingGame.isOver()) {
            outputView.printCarsPosition(racingGame.move());
        }
    }
}
