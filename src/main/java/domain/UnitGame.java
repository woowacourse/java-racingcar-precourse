package domain;

import domain.racingcar.Car;
import utils.RandomUtils;

import java.util.List;

import static utils.RandomUtils.LOWER_BOUNDARY;
import static utils.RandomUtils.UPPER_BOUNDARY;

public class UnitGame {
    private final List<Car> cars;

    public UnitGame(List<Car> cars) {
        this.cars = cars;
    }

    public void giveCarRandomNumber() {
        cars.forEach(car -> car.increasePosition(RandomUtils.nextInt(LOWER_BOUNDARY, UPPER_BOUNDARY)));
    }
}
