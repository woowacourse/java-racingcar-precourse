package racing;

import java.util.ArrayList;

import communicate.Text;

import racingcar.Car;

public class Race {
    private final RaceManager raceManager = new RaceManager();

    private void oneSet(ArrayList<Car> cars) {

        for (Car car : cars) {

            if (car.isMovable()) {
                car.move();
            }

        }

    }

    public void startGame() {
        ArrayList<Car> cars = raceManager.registerCars();
        int attemptNumber = raceManager.assignAttemptNumber();

        System.out.println(Text.LINE_BREAK + Text.RACE_RESULT);

        for (int i = 0; i < attemptNumber; i++) {
            oneSet(cars);
            raceManager.showOneSetResult();
        }

        raceManager.announceWinner();
    }
}
