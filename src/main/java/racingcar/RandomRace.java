package racingcar;

import domain.Car;
import utils.RandomUtils;

import java.util.List;

public class RandomRace extends Race {
    private static final int MIN_RANDOM_DIGIT = 0;
    private static final int MAX_RANDOM_DIGIT = 9;

    public RandomRace(List<Car> cars, int round) {
        super(cars, round);
    }

    @Override
    protected void makeCarRun() {
        cars.forEach(car -> car.run(randomly()));
    }

    private int randomly() {
        return RandomUtils.nextInt(MIN_RANDOM_DIGIT, MAX_RANDOM_DIGIT);
    }
}
