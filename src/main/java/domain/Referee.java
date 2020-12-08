package domain;

import java.util.List;

public class Referee {
    private int maxPosition;

    public int calculateMaxPosition(List<Car> cars) {
        for (Car car : cars) {
            setMaxPosition(car);
        }
        return maxPosition;
    }

    private void setMaxPosition(Car car) {
        if (isMaxPosition(car.getPosition())) {
            maxPosition = car.getPosition();
        }
    }

    private boolean isMaxPosition(int carPosition) {
        return carPosition > maxPosition;
    }

    public RaceWinner setWinner(List<Car> cars) {
        RaceWinner raceWinner = new RaceWinner();
        for (Car car : cars) {
            chooseWinner(raceWinner, car);
        }
        return raceWinner;
    }

    private void chooseWinner(RaceWinner raceWinner, Car car) {
        if (isWinner(car)) {
            raceWinner.addRaceWinner(car);
        }
    }

    private Boolean isWinner(Car car) {
        return car.getPosition() == maxPosition;
    }
}
