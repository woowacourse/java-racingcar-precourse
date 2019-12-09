/*
 * Cars.java
 *
 * v 0.0.0
 *
 * 2019.12.06
 *
 * Copyright 2019. DunDung all rights reserved.
 */

package domain;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Cars {
    private static final int MIN_SIZE = 2;

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        validateSize(cars);
        validateDuplicatedName(cars);
        this.cars = cars;
    }

    public Car getCarByIndex(int index) {
        return cars.get(index);
    }

    public int size() {
        return cars.size();
    }

    public int getForemostPosition() {
        return cars.stream()
                .max(Comparator.comparing(Car::getPosition))
                .get()
                .getPosition();
    }

    public List<Car> findByPosition(int position) {
        return cars.stream()
                .filter(car -> position == car.getPosition())
                .collect(Collectors.toList());
    }

    private void validateSize(List<Car> cars) {
        if (cars.size() < MIN_SIZE) {
            throw new IllegalArgumentException("2대 이상의 차가 아닙니다.");
        }
    }

    private void validateDuplicatedName(List<Car> cars) {
        Set<String> noneDuplicatedCarNames = new HashSet<>();

        for (Car car : cars) {
            if (!noneDuplicatedCarNames.add(car.getName())) {
                throw new IllegalArgumentException("중복된 차 이름이 있습니다.");
            }
        }
    }
}
