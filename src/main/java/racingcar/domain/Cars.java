package racingcar.domain;

import utils.RandomGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private static int MOVE_FOR_MIN_NUM = 4;
    private List<Car> carList = new ArrayList<>();

    public Cars(String[] carNames) {
        carList.addAll(Arrays.stream(carNames)
                .map(name -> new Car(name))
                .collect(Collectors.toList()));
    }

    public void move() {
        carList.stream()
                .forEach(car -> {
                    if (RandomGenerator.generate() <= MOVE_FOR_MIN_NUM) {
                        car.move();

                    }
                });
    }


}
