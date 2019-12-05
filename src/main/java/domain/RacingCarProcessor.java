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
        for (int i = 0 ; i < registeredCar.size(); i++) {
            System.out.println(registeredCar.get(i).getName() + " : " + getCarPosition(registeredCar, i));
        }
    }

    private String getCarPosition(List<Car> registeredCar, int index) {
        String progressState = "";

        for (int i = 0; i < registeredCar.get(index).getPosition(); i++) {
            progressState += "-";
        }

        return progressState;
    }
}
