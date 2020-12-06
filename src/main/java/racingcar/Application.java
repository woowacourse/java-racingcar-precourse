package racingcar;

import java.util.Scanner;
import racingcar.controller.RacingCarGameController;
import racingcar.io.InputView;

public class Application {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        InputView.scanner = scanner;
        RacingCarGameController game = new RacingCarGameController();
        game.start();
    }

}
