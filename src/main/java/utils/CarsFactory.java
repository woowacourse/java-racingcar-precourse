package utils;

import racingcar.Car;
import racingcar.Cars;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.List;

public class CarsFactory {
    private CarsFactory(){}

    public static Cars createCars(String[] names){
        List carList = Arrays.stream(names)
                .map(Car::new)
                .collect(Collectors.toList());
        return new Cars(carList);
    }
}
