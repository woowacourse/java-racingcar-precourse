package racingcar.domain;

import racingcar.domain.engine.Engine;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {

    private List<Car> cars;
    private int fastestPosition = 0;

    public RacingCars(List<Car> cars) {
        this.cars = cars;
    }

    public String move(Engine engine) {
        StringBuilder moveResult = new StringBuilder();
        for (Car car : cars) {
            car.move(engine);
            calculateFastestPosition(car.getPosition());
            moveResult
                    .append(car.toString())
                    .append("\n");
        }
        return moveResult.toString();
    }

    private void calculateFastestPosition(int carPosition) {
        if (carPosition > fastestPosition) {
            fastestPosition = carPosition;
        }
    }

    public List<Car> getFastestCars() {
        List<Car> fastestCars = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == fastestPosition) {
                fastestCars.add(car);
            }
        }
        return fastestCars;
    }
}
