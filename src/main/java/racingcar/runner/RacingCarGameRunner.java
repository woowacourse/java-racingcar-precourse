package racingcar.runner;

import racingcar.domain.RacingCarGame;
import racingcar.utils.CarGameInputHandler;

public class RacingCarGameRunner {

    final private DisplayHandler displayHandler;
    final private RacingCarGame game;
    final private int playCount;

    public RacingCarGameRunner() {
        this.displayHandler = new DisplayHandler();
        this.game = new RacingCarGame(CarGameInputHandler.getValidCarNames());
        this.playCount = CarGameInputHandler.getValidPlayCount();
    }

    public void run() {
        for (int i = 0; i < playCount; i++) {
            game.moveCars();
            displayHandler.appendResultBlock(game.getGameStatus());
        }
        displayHandler.appendWithLineBreak(game.getWinners());
        displayHandler.displayResult();
    }

}
