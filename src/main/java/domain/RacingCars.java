package domain;

import generater.RandomGenerater;

import java.util.Collections;
import java.util.List;

public class RacingCars {
    private final List<Car> racingCars;

    public RacingCars(List<Car> racingCars) {
        this.racingCars = racingCars;
    }

    public void move() {
        this.racingCars.forEach(car -> {
            car.move(RandomGenerater.generateRandom());
        });
    }

    public List<Car> getRacingCars() {
        return Collections.unmodifiableList(racingCars);
    }
}
