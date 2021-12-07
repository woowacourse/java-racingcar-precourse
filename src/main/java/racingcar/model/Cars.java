package racingcar.model;

import java.util.List;

public class Cars {
    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void race(int attempts) {
        System.out.println();
        for (int i = 0; i < attempts; i++) {
            printResult();
            System.out.println();
        }
    }

    private void printResult() {
        this.cars.forEach(car -> car.printResult());
    }
}
