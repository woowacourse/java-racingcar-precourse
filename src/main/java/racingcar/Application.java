package racingcar;

import racinggame.RacingGame;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        RacingGame racingGame = RacingGame.prepareRacingGame(scanner);
        racingGame.gamePlay();
        racingGame.gameResult();
    }
}
