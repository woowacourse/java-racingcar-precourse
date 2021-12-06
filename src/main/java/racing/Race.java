package racing;

import java.util.ArrayList;

import communicate.Text;

import racingcar.Car;

public class Race {
    private RaceManager raceManager = new RaceManager();
    private ArrayList<Car> cars;
    private int attemptNumber;

    private void oneSet() {

        for (Car car : cars) {

            if (car.isMovable()) {
                car.move();
            }

        }

    }

    public void startGame() {
        cars = raceManager.registerCars();
        attemptNumber = raceManager.assignAttemptNumber();

        System.out.println(Text.LINE_BREAK + Text.RACE_RESULT);

        for (int i = 0; i < attemptNumber; i++) {
            oneSet();
            raceManager.showOneSetResult();
        }

    }
}
