package domain;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class RacingCarProcessor {
    private final int MIN_NUMBER = 0;
    private final int MAX_NUMBER = 10;
    private final int GO_PERMISSION_MINIMUM_VALUE = 3;

    public List<Integer> carMovementRandomGenerator(int tryTimes) {
        return ThreadLocalRandom.current()
                .ints(MIN_NUMBER, MAX_NUMBER)
                .limit(tryTimes)
                .boxed()
                .collect(Collectors.toList());
    }

    public boolean goForwardPermission(List<Integer> goForward, int round) {
        return goForward.get(round) > GO_PERMISSION_MINIMUM_VALUE;
    }

    public void carState(List<Car> registeredCar) {
        for (int i = 0; i < registeredCar.size(); i++) {
            System.out.println(registeredCar.get(i).getName()
                    + " : "
                    + getCarPosition(
                            registeredCar.get(i).getPosition(), ""));
        }
    }

    private String getCarPosition(int position, String bar) {
        if (position == 0) {
            return bar;
        }
        return getCarPosition(--position, bar + "-");
    }

    public void iteratorCarPositionCheck(List<Car> registeredCar, int round) {
        for (int i = 0; i < registeredCar.size(); i++) {
            isCarPermissionOn(registeredCar, round, i);
        }
        carState(registeredCar);
        System.out.println();
    }

    public void isCarPermissionOn(List<Car> registeredCar, int round, int carType) {
        if (registeredCar.get(carType).getGoForward(round) > 3) {
            registeredCar.get(carType).goForwardPosition();
        }
    }
}
