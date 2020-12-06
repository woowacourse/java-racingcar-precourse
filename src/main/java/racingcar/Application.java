package racingcar;

import java.util.Scanner;
import racingcar.controller.Game;

public class Application {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final Game game = new Game(scanner);
        game.play();
    }
}
