/*
 *  @CarController.java
 *
 *  @Version: 0.1
 *
 *  @Date: 2019.12.09
 *
 *  @Author: pandahun
 */

package domain;

import static domain.RacingGame.ZERO;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {

    private final List<Car> cars;

    public RacingCars(List<Car> cars) {
        this.cars = cars;
    }

    public void move() {
        cars.forEach(car -> move());
    }

    public List<Car> getWinners() {
        int maxPosition = findMaxPosition();
        List<Car> winners = findWinners(maxPosition);

        return winners;
    }

    private int findMaxPosition() {
        return cars.stream()
                .map(Car::getPosition)
                .max(Integer::compareTo)
                .orElse(ZERO);
    }

    private List<Car> findWinners(int maxPosition) {
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }



}
