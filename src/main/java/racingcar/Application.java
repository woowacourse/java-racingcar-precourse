package racingcar;

import racingcar.controller.Game;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행

        Game game = new Game(scanner);
        game.start();

    }
}
