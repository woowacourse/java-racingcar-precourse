package racingcar;

import racingcar.domains.Game.Game;
import racingcar.domains.error.RacingCarGameException;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        Game game = new Game(scanner);
        game.run();
    }
}
