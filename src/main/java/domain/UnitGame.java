package domain;

import domain.racingcar.Car;
import utils.RandomUtils;

import java.util.List;

public class UnitGame {
    private List<Car> cars;
    public void makeRandomNumbers(){
        cars.forEach(car -> car.increasePosition(RandomUtils.nextInt(0, 9)));
    }
}
