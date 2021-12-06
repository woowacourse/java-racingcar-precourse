package racingcar.runner;

import racingcar.domain.RacingCarGame;
import racingcar.utils.CarGameInputHandler;

public class RacingCarGameRunner {

    private DisplayHandler displayHandler;
    private RacingCarGame game;
    private int playCount;

    public void run() {
        initGame();
        for (int i = 0; i < playCount; i++) {
            game.moveCars();
            displayHandler.appendResultBlock(game.getGameStatus());
        }
        displayHandler.appendWithLineBreak(game.getWinners());
        displayHandler.displayResult();
    }

    private void initGame() {
        this.displayHandler = new DisplayHandler();
        this.game = new RacingCarGame(CarGameInputHandler.getValidCarNames());
        this.playCount = CarGameInputHandler.getValidPlayCount();
    }
}
