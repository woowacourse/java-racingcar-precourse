package domain;

import domain.racingcar.Car;
import utils.RandomUtils;

import java.util.List;

public class UnitGame {
    private final List<Car> cars;

    public UnitGame(List<Car> cars) {
        this.cars = cars;
    }

    public void makeRandomNumbers(){
        cars.forEach(car -> car.increasePosition(RandomUtils.nextInt(0, 9)));
    }
}
