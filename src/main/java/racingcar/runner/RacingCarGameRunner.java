package racingcar.runner;

import racingcar.domain.RacingCarGame;
import racingcar.utils.UserInput;

public class RacingCarGameRunner {

    private ResultPrinter printer;
    private RacingCarGame game;
    private Integer playCount;

    public void run() {
        initGame();
        for (int i = 0; i < playCount; i++) {
            game.moveCars();
            printer.appendResultBlock(game.getGameStatus());
        }
        printer.appendNewLine(game.getWinners());
        printer.printResult();
    }

    private void initGame() {
        this.printer = new ResultPrinter();
        this.game = new RacingCarGame(UserInput.getValidCarNames());
        this.playCount = UserInput.getValidPlayCount();
    }
}
