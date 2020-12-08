package racinggame;

import domain.Car;
import domain.RaceWinner;
import domain.RacingCars;

public class Referee {
    private int maxPosition;

    public void calculateMaxPosition(RacingCars racingCars) {
        for (Car car : racingCars.getCarList()) {
            checkMaxPosition(car);
        }
    }

    private void checkMaxPosition(Car car) {
        int carPosition = car.getPosition();
        if (isMaxPosition(carPosition)) {
            maxPosition = carPosition;
        }
    }

    private boolean isMaxPosition(int carPosition) {
        return carPosition > maxPosition;
    }

    public RaceWinner setWinner(RacingCars racingCars) {
        RaceWinner raceWinner = new RaceWinner();
        for (Car car : racingCars.getCarList()) {
            selectWinner(raceWinner, car);
        }
        return raceWinner;
    }

    private void selectWinner(RaceWinner raceWinner, Car car) {
        if (isWinner(car)) {
            raceWinner.addRaceWinner(car);
        }
    }

    private Boolean isWinner(Car car) {
        return car.getPosition() == maxPosition;
    }
}
