package racingcar;

import utils.RandomUtils;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private static final int RANDOM_START_VALUE = 0;
    private static final int RANDOM_END_VALUE = 10;
    private static final int GO_FORWARD_VALUE = 4;

    List<Car> cars;

    public Cars(List<String> names) {
        cars = names.stream().map(Car::new).collect(Collectors.toList());
    }

    private boolean isGoForward() {
        return RandomUtils.nextInt(RANDOM_START_VALUE, RANDOM_END_VALUE) >= GO_FORWARD_VALUE;
    }
}
