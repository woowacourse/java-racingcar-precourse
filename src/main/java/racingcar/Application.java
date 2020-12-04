package racingcar;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        RacingGame racingGame = new RacingGame();

        racingGame.startGame(scanner);
        for(int i = 0; i < racingGame.getTryNum(); i++){
            racingGame.playOneRound();
        }
        racingGame.endGame();

        scanner.close();
    }
}
