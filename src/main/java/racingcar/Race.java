package racingcar;

import utils.RandomUtils;

import java.util.ArrayList;
import java.util.List;

public class Race {
    private final int attemptNum;
    private final List<Car> cars;

    public Race(List<Car> cars, int attemptNum) {
        this.cars = new ArrayList<>(cars);
        this.attemptNum = attemptNum;
    }

    public void raceStart() {
        for (int i = 0; i < attemptNum; i++) {
            Car car = cars.get(i);
            carTryMove(car);
            printCarCurrentLocation(car);
            System.out.println();
        }
        winnerPrize();
    }

    public void carTryMove(Car car) {
        int fate = RandomUtils.nextInt(0, 10);
        if (fate <= 3) {
            return;
        }
        car.move();
    }


}
