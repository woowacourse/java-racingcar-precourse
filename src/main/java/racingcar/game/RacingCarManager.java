package racingcar.game;

import racingcar.Car;
import racingcar.domain.CarMovingFlag;

import java.util.ArrayList;
import java.util.List;

public class RacingCarManager {
    private static final int MAX_LEN_CAR_NAME = 5;
    private static final String MIDDLE_DELIM_OF_RESULT = " : ";
    private static final String MOVING_POSITION_MARK = "-";
    private static final int START_INDEX = 0;

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
        int maxPosition = this.maxPosition();
        if (maxPosition == Integer.MIN_VALUE) {
            return new ArrayList<>();
        }

        return makeTheListOfOnlyWinnerName(maxPosition);
    }

    private List<String> makeTheListOfOnlyWinnerName(int maxPosition) {
        List<String> winnerNameList = new ArrayList<>();
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

    public List<String> nowPositionResultStrList() {
        List<String> nowPositionResult = new ArrayList<>();
        for (Car racingCar : this.racingCarList) {
            nowPositionResult.add(this.nowPositionResult(racingCar));
        }

        return nowPositionResult;
    }

    private String nowPositionResult(Car racingCar) {
        StringBuilder carPositionResultStringBuilder = new StringBuilder();
        carPositionResultStringBuilder.append(racingCar.getName()).append(MIDDLE_DELIM_OF_RESULT);
        for (int indexOfPosition = START_INDEX; indexOfPosition < racingCar.getPosition(); indexOfPosition++) {
            carPositionResultStringBuilder.append(MOVING_POSITION_MARK);
        }
        return carPositionResultStringBuilder.toString();
    }
}
