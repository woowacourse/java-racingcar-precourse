package racingcar.domain;

import utils.RandomGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private static int MOVE_FOR_MIN_NUM = 4;
    private static String WINNER_PRINT_DELIMITER = " ";
    private List<Car> carList = new ArrayList<>();
    private int maxDistance;

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
                        updateWinner(car);
                    }
                });
    }

    private void updateWinner(Car car) {
        if (car.isMaxPosition(maxDistance)) {
            maxDistance++;
        }
    }

    public String position() {
        return carList.stream()
                .map(car -> car.toString())
                .collect(Collectors.joining());
    }

}
