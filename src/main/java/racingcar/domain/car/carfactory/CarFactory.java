package racingcar.domain.car.carfactory;

import racingcar.domain.car.Car;
import racingcar.domain.car.CarInterface;

public class CarFactory extends Factory {
    @Override
    protected CarInterface manufactureCar(String name) {
        CarInterface car = new Car(name);
        return car;
    }
}
