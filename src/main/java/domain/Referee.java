package domain;

public class Referee {
    private int maxPosition;

    public void calculateMaxPosition(RacingCars racingCars) {
        for (Car car : racingCars.getCarList()) {
            setMaxPosition(car);
        }
    }

    private void setMaxPosition(Car car) {
        if (isMaxPosition(car.getPosition())) {
            maxPosition = car.getPosition();
        }
    }

    private boolean isMaxPosition(int carPosition) {
        return carPosition > maxPosition;
    }

    public RaceWinner setWinner(RacingCars racingCars) {
        RaceWinner raceWinner = new RaceWinner();
        for (Car car : racingCars.getCarList()) {
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
