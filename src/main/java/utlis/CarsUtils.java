/*
 * CarsUtils.java
 *
 * v 0.0.0
 *
 * 2019.12.07
 *
 * Copyright 2019. DunDung all rights reserved.
 */

package utlis;

import java.util.ArrayList;
import java.util.List;

import domain.Car;
import domain.Cars;

public class CarsUtils {
    private static final String COMMA = ",";

    public static Cars createCarsByCarNames(String carNames) {
        List<Car> cars = new ArrayList<>();

        for (String carName : carNames.split(COMMA)) {
            cars.add(new Car(carName));
        }
        return new Cars(cars);
    }
}
