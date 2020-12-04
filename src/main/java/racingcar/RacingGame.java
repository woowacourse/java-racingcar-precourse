package racingcar;

import java.util.ArrayList;
import java.util.List;

import racingcar.InputView;

public class RacingGame {
    private String userInput;
    private String attemptsInput;
    private List<Car> cars;
    private int attemptsNum;
    private static String WINNER_MESSAGE = "최종 우승자: ";

    public void readyGame() {
        userInput = InputView.askCarName();
        if (CheckValidation.carName(userInput)) {
            cars = Car.makeCarList(userInput);
        }

        attemptsInput = InputView.askNumberOfAttempts();
        if (CheckValidation.numberOfAttepmts(attemptsInput)) {
            attemptsNum = Integer.parseInt(attemptsInput);
        }
    }

    public void playGame() {
        for (int i = 0; i < attemptsNum; i++){
            setCarPosition(cars);
            Car.displayPosition(cars);
        }
    }

    public static void setCarPosition(List<Car> cars) {
        for (Car car : cars) {
            Car.setPosition(car);
        }
    }

    public void displayWinner() {
        List<String> winnerList = Car.getWinner(cars);
        String[] winnerArr = winnerList.toArray(new String[winnerList.size()]);

        String winner = String.join(", ", winnerArr);
        System.out.print(WINNER_MESSAGE + winner);
    }
}
