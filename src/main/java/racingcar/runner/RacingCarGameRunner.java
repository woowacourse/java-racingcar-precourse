package racingcar.runner;

import java.util.List;
import java.util.function.Supplier;
import racingcar.domain.RacingCarGame;
import racingcar.utils.CarGameInputHandler;
import racingcar.utils.DisplayHandler;

public class RacingCarGameRunner {

    final private DisplayHandler displayHandler;
    final private RacingCarGame game;
    final private int playCount;

    public RacingCarGameRunner() {
        this.displayHandler = new DisplayHandler();
        this.game = new RacingCarGame(getValidNames());
        this.playCount = getValidPlayCount();
    }

    public void run() {
        for (int i = 0; i < playCount; i++) {
            game.moveCars();
            displayHandler.appendResultBlock(game.getGameStatus());
        }
        displayHandler.appendWithLineBreak(game.getWinners());
        displayHandler.displayResult();
    }

    private List<String> getValidNames() {
        return getValidInput(CarGameInputHandler::getCarNames);
    }

    private int getValidPlayCount() {
        return getValidInput(CarGameInputHandler::getPlayCount);
    }

    private <T> T getValidInput(Supplier<T> sup) {
        while (true) {
            try {
                return sup.get();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
