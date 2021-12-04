package racingcar.runner;

import java.util.List;
import racingcar.domain.RacingCarGame;
import racingcar.utils.CarGameInputHandler;

public class RacingCarGameRunner {

    public static void run() {
        RacingCarGame game = new RacingCarGame(getValidNames());
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
}
