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
        setRoundCount();
        moveCarsEachRound();
        OutputView.printWinners(racingCars);
    }

    private void setRacingCars() {
        try {
            racingCars = new RacingCars(inputView.getCarNames());
        } catch (IllegalArgumentException e) {
            OutputView.printError(e);
            setRacingCars();
        }
    }

    private void setRoundCount() {
        try {
            gameRound = new GameRound(inputView.getRoundCount());
        } catch (IllegalArgumentException e) {
            OutputView.printError(e);
            setRoundCount();
        }
    }

    private void moveCarsEachRound() {
        racingCars.moveFor(gameRound.getCount());
    }
}
