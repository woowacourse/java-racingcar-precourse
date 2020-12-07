package racingcar.domain;

import utils.RandomUtils;

public class ForwardingChecker {
    private static final int MAX_RACING_NUMBER = 9;
    private static final int MIN_RACING_NUMBER = 0;
    private static final int MOVING_CRITERION = 4;

    public static void run(Cars cars) {
        cars.getCars().stream()
                .filter(ForwardingChecker::isMovable)
                .forEach(Car::forwardOneStep);
    }

    private static boolean isMovable(Car car) {
        int racingNumber = RandomUtils.nextInt(MIN_RACING_NUMBER, MAX_RACING_NUMBER);
        if (racingNumber >= MOVING_CRITERION) {
            return true;
        }
        return false;
    }
}
