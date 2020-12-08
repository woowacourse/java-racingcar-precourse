package racingcar;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행

        IRacingGamePlayers data = new RacingGamePlayers();
        IRacingGamePrinter printer = new RacingGamePrinter();
        IRacingGame game = new RandomDiceRacingGame(data, printer);
        IController controller = new GameController(game, scanner);

        controller.setUp();
        controller.run();
    }
}
