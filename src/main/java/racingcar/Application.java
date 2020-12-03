package racingcar;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행
        RacingGame racingGame = new RacingGame(scanner);
        racingGame.runGame();
    }
}
