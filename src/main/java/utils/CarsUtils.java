/*
 * CarsUtils.java
 *
 * v 0.0.0
 *
 * 2019.12.07
 *
 * Copyright 2019. DunDung all rights reserved.
 */

package utils;

import java.util.ArrayList;
import java.util.List;

import domain.Car;
import domain.Cars;

public class CarsUtils {
    private static final String COMMA = ",";
    private static final String WRONG_INPUT = "입력 형식이 올바르지 않습니다.";

    public static Cars createCarsByCarNames(String carNames) {
        validateLastIndexComma(carNames);
        List<Car> cars = new ArrayList<>();

        for (String carName : carNames.split(COMMA)) {
            cars.add(new Car(carName));
        }
        return new Cars(cars);
    }

    private static void validateLastIndexComma(String carNames) {
        if (carNames.lastIndexOf(COMMA) == carNames.length()-1) {
            throw new IllegalArgumentException(WRONG_INPUT);
        }
    }
}
