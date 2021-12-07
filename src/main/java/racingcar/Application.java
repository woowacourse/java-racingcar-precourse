package racingcar;

import java.io.IOException;

public class Application {
    public static void main(String[] args) {
        // TODO 구현 진행
        CarRacingGame carRacingGame = new CarRacingGame();
        try {
            carRacingGame.startGame();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}