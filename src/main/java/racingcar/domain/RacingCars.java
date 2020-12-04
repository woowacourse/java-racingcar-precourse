package racingcar.domain;

import racingcar.domain.engine.Engine;

import java.util.List;

public class RacingCars {

    private List<Car> cars;

    public RacingCars(List<Car> cars) {
        this.cars = cars;
    }

    public String move(Engine engine) {
        StringBuilder moveResult = new StringBuilder();
        for (Car car : cars) {
            car.move(engine);
            moveResult
                    .append(car.toString())
                    .append("\n");
        }
        return moveResult.toString();
    }

}
