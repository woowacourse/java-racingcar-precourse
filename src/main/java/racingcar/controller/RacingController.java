package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.RacingRound;
import racingcar.domain.RacingGame;
import racingcar.view.InputDisplay;
import racingcar.view.OutputDisplay;

import java.util.List;

public class RacingController {

    private final InputDisplay inputDisplay;
    private final OutputDisplay outputDisplay;

    public RacingController(InputDisplay inputDisplay, OutputDisplay outputDisplay) {
        this.inputDisplay = inputDisplay;
        this.outputDisplay = outputDisplay;
    }

    public void playRacingGame() {
        RacingGame racingGame = new RacingGame(inputDisplay, outputDisplay);
        List<Car> cars = racingGame.makeCarNameList();

        RacingRound racingRound = new RacingRound(racingGame, inputDisplay, outputDisplay);
        int rounds = Integer.parseInt(racingRound.determineGameRound());

        racingGame.playTotalRound(cars, rounds);

        String makeWinnerPrintFormat = racingGame.announceWinner(cars);
        outputDisplay.printWinner(makeWinnerPrintFormat);
    }

}
