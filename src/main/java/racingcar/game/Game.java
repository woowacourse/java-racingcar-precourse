package racingcar.game;

import racingcar.car.RacingCars;
import view.InputView;
import view.OutputView;

public class Game {

    private final InputView inputView;
    private RacingCars racingCars;
    private GameRound gameRound;

    public Game(InputView inputView) {
        this.inputView = inputView;
    }

    public void play() {
        setRacingCars();
        setGameRound();
        moveCarsEachRound();
        OutputView.printWinners(racingCars);
    }

    private void setRacingCars() {
        try {
            racingCars = new RacingCars(inputView.setCarNames());
        } catch (IllegalArgumentException e) {
            OutputView.printError(e);
            setRacingCars();
        }
    }

    private void setGameRound() {
        try {
            gameRound = new GameRound(inputView.setRoundCount());
        } catch (IllegalArgumentException e) {
            OutputView.printError(e);
            setGameRound();
        }
    }

    private void moveCarsEachRound() {
        racingCars.moveFor(gameRound.getCount());
    }
}
