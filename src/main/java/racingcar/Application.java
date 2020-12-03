package racingcar;

import java.util.Scanner;

public class Application {
    public static final int MINIMUM_VALUE = 0;
    public static final int MAXIMUM_RANGE = 9;

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        playGame(scanner);
    }

    private static void playGame(Scanner scanner) {
        Player player = new Player();
        CarRacingGame carRacingGame = player.inputInfoForPlayGame(scanner);
        carRacingGame.inputTest();
    }
}
