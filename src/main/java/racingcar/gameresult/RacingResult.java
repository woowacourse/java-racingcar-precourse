package racingcar.gameresult;

import racingcar.car.Car;

public class RacingResult {
    private final String carName;
    private final int position;

    public RacingResult(Car car) {
        carName = car.getName();
        position = car.getPosition();
    }

    public String getCarName() {
        return carName;
    }

    public int getPosition() {
        return position;
    }
}
