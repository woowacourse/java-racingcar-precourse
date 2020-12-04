package racinggame;

import domain.Car;
import domain.RaceWinner;
import domain.RacingCars;

public class Referee {
    private int maxDistance;

    public void calculateMaxDistance(RacingCars racingCars) {
        for (Car car : racingCars.getCarList()) {
            checkMaxDistance(car);
        }
    }

    private void checkMaxDistance(Car car) {
        int carPosition = car.getPosition();
        if (carPosition > maxDistance) {
            maxDistance = carPosition;
        }
    }

    public RaceWinner selectWinner(RacingCars racingCars) {
        RaceWinner raceWinner = new RaceWinner();
        for (Car car : racingCars.getCarList()) {
            if (car.getPosition() == maxDistance) {
                raceWinner.addRaceWinner(car);
            }
        }
        return raceWinner;
    }
}
