package racingcar.runner;

import java.util.List;
import racingcar.domain.RacingCarGame;
import racingcar.utils.CarGameInputHandler;

public class RacingCarGameRunner {

    public static void run() {
        RacingCarGame game = new RacingCarGame(getValidNames());
        final int moveCount = getValidPlayCount();
        for (int i = 0; i < moveCount; i++) {
            game.moveCars();
        }
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
