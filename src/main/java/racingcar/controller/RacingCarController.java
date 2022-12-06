package racingcar.controller;

import racingcar.domain.CarRandomMoveNumberGenerator;
import racingcar.domain.Cars;
import racingcar.domain.RacingCarGame;
import racingcar.domain.TryCommand;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private RacingCarGame racingCarGame;

    public void runGame() {
        makeRacingCarGame();
        playGame();
        endGame();
    }

    private void endGame() {
        outputView.printWinner(racingCarGame.findWinner());
    }

    private void playGame() {
        TryCommand tryCommand = askTryCommand();
        while(tryCommand.tryMove()){
            racingCarGame.move();
            outputView.printResult(racingCarGame.getCars());
        }
    }

    private void makeRacingCarGame() {
        racingCarGame = new RacingCarGame(askCar());
        outputView.printBlank();
    }

    private TryCommand askTryCommand() {
        outputView.printInputTry();
        return new ReEnterProcessor<>(inputView::readTryCommand, outputView::printExceptionMessage).process();
    }


    private Cars askCar() {
        outputView.printInputCarName();
        return new ReEnterProcessor<>(inputView::readCarName, outputView::printExceptionMessage).process();
    }
}
