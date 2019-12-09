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

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Cars {
    private static final int MIN_SIZE = 2;

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        validateSize(cars);
        validateDuplicatedName(cars);
        this.cars = cars;
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
