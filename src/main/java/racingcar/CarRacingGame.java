package racingcar;


import java.io.IOException;

public class CarRacingGame {
    private static String carNameInput;
    private static String numOfAttemptsInput;

    public static void readyGame() {
        try {
            carNameInput = InputView.getCarName();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            numOfAttemptsInput = InputView.getNumberOfAttempts();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void playGame() {

    }

    public static void endGame() {

    }
}
