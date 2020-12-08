package racingcar;

import java.util.Scanner;
import racingcar.controller.RacingCarGameController;

public class Application {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        RacingCarGameController game = new RacingCarGameController(scanner);
        game.start();
    }

}
