package racingcar;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        PlayerResponse playerResponse = new PlayerResponse(scanner);
        final String[] carNames = playerResponse.getCarNames();
        final int moves = playerResponse.getHowManyMoves();
        scanner.close();

        RacingCarGame racingCarGame = new RacingCarGame(carNames, moves);
        racingCarGame.initGame();
    }
}
