package racingcar;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Application {
    public static void main(String[] args) {
        // TODO 구현 진행
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        CarRacingGame carRacingGame = new CarRacingGame();

        CarRacingGame.readyGame();
        CarRacingGame.playGame();
        CarRacingGame.endGame();
    }
}