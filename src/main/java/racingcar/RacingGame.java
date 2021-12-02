package racingcar;

import java.util.ArrayList;
import java.util.Collections;

public class RacingGame {
    String[] carNames;
    Car[] cars;
    int playTimes;

    public void start() {
        inputCarNames();
        readyCars(carNames);

        inputPlayTimes();

        printRaceResults(cars, playTimes);

        printFinalWinnersName(cars);
    }

    private void printInputCarNames() {
        System.out.println(Constants.INPUT_CAR_NAMES_MSG);
    }

    private void printInputPlayTimes() {
        System.out.println(Constants.INPUT_PLAY_TIMES_MSG);
    }

    private void printRaceResults(Car[] cars, int playTimes) {
        System.out.println();
        System.out.println(Constants.RACE_RESULT_MSG);

        for (int times = 0; times < playTimes; times++) {

            for (Car car : cars) {
                car.race();
                String carName = car.getName();
                String carPosMsg = String.join("", Collections.nCopies(car.getPosition(), "-"));
                System.out.println(carName + " : " + carPosMsg);
            }

            System.out.println();
        }
    }

    private void printFinalWinnersName(Car[] cars) {
        ArrayList<String> finalWinners = new ArrayList<String>();
        int winnerPos = winnersPosition(cars);

        for (Car car : cars) {
            if (car.getPosition() == winnerPos) {
                finalWinners.add(car.getName());
            }
        }

        String finalWinnersMsg = Constants.FINAL_WINNERS_MSG + " : " + String.join(", ", finalWinners);
        System.out.println(finalWinnersMsg);
    }

    private void inputCarNames() {
        printInputCarNames();

        try {
            carNames = new InputValidator().carNames();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            inputCarNames();
        }
    }

    private void readyCars(String[] carNames) {
        cars = new Car[carNames.length];
        for (int i = 0; i < carNames.length; i++) {
            cars[i] = new Car(carNames[i]);
        }
    }

    private void inputPlayTimes() {
        printInputPlayTimes();

        try {
            playTimes = new InputValidator().playTimes();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            inputPlayTimes();
        }
    }

    private int winnersPosition(Car[] cars) {
        int maxPos = 0;

        for (Car car : cars) {
            if (maxPos < car.getPosition()) {
                maxPos = car.getPosition();
            }
        }

        return maxPos;
    }
}
