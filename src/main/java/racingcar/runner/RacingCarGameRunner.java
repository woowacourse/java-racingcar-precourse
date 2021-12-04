package racingcar.runner;

import java.util.List;
import racingcar.domain.RacingCarGame;
import racingcar.utils.CarGameInputHandler;

public class RacingCarGameRunner {

    public static void run() {
        RacingCarGame game = newGame();
        game.runCars();
    }

    private static RacingCarGame newGame() {
        return new RacingCarGame(getValidNames(), getValidPlayCount());
    }

    private static List<String> getValidNames() {
        while (true) {
            try {
                return CarGameInputHandler.getCarNames();
            }catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    private static int getValidPlayCount() {
        while (true) {
            try {
                return CarGameInputHandler.getPlayCount();
            }catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
            }
        }
    }

}
