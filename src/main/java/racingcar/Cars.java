package racingcar;

import static game.Message.print;
import static game.Rule.END_RANGE;
import static game.Rule.START_RANGE;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import utils.RandomUtils;

/**
 * @author yhh1056
 * @since 2020/12/05
 */
public class Cars {
    private static final int FIRST_CAR = 0;

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void moves(final int gameCount) {
        for (int i = 0; i < gameCount; i++) {
            move();
        }
    }

    private void move() {
        for (Car car : cars) {
            car.move(getRandomNumber());
            print(car.toString());
        }
        print();
    }

    private int getRandomNumber() {
        return RandomUtils.nextInt(START_RANGE, END_RANGE);
    }

    public List<String> findWinners() {
        return findCoWinners(getFirstCar());
    }

    public Car getFirstCar() {
        Collections.sort(cars);
        return cars.get(FIRST_CAR);
    }

    private List<String> findCoWinners(Car winner) {
        return cars.stream()
                   .filter(winner::equalsPosition)
                   .map(Car::getName)
                   .collect(Collectors.toList());
    }
}
