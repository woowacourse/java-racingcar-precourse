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

import java.util.List;

public class Cars {
    private static final int MIN_SIZE = 2;

    private List<Car> cars;

    public Cars(List<Car> cars) {
        validateSize(cars);
        this.cars = cars;
    }

    private void validateSize(List<Car> cars) {
        if (cars.size() < MIN_SIZE) {
            throw new IllegalArgumentException("2대 이상의 차가 아닙니다.");
        }
    }

    //2대 이상만 로직
}
