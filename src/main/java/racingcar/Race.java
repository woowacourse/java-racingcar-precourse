package racingcar;

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
            carExcel(car);
            System.out.println();
        }
        winnerPrize();
    }


}
