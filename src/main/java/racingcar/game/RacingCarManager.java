package racingcar.game;

import racingcar.Car;
import racingcar.domain.CarMovingFlag;

import java.util.ArrayList;
import java.util.List;

public class RacingCarManager {
    private static final int MAX_LEN_CAR_NAME = 5;

    private final List<Car> racingCarList;

    public RacingCarManager(List<String> carNameList) {
        this.racingCarList = new ArrayList<>();
        for (String carName : carNameList) {
            this.racingCarList.add(this.makeValidateCar(carName));
        }
    }

    private Car makeValidateCar(String carName) {
        if (carName.length() <= MAX_LEN_CAR_NAME) {
            return new Car(carName);
        }

        throw new IllegalArgumentException();
    }

    public int numberOfRacingCar() {
        return this.racingCarList.size();
    }

    public void updateRacingCarPosition(List<CarMovingFlag> carMovingFlagList) {
        for (int indexOfCarForChangingPosition = 0; indexOfCarForChangingPosition < carMovingFlagList.size(); indexOfCarForChangingPosition += 1) {
            this.racingCarList.get(indexOfCarForChangingPosition).updatePositionByFlag(carMovingFlagList.get(indexOfCarForChangingPosition));
        }
    }

    public List<String> getNowWinnerPlayersName() {
        List<String> winnerNameList = new ArrayList<>();

        int maxPosition = this.maxPosition();
        if (maxPosition == Integer.MIN_VALUE) {
            return winnerNameList;
        }

        for (Car car : this.racingCarList) {
            if (car.getPosition() == maxPosition) {
                winnerNameList.add(car.getName());
            }
        }

        return winnerNameList;
    }

    private int maxPosition() {
        int maxPosition = Integer.MIN_VALUE;

        for (Car car : this.racingCarList) {
            maxPosition = Math.max(car.getPosition(), maxPosition);
        }

        return maxPosition;
    }
}
