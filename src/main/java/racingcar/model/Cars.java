package racingcar.model;

import java.util.List;
import java.util.stream.Collectors;

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

    public String getWinners() {
        return getWinnersByMaxPosition(getMaxPosition());
    }

    private String getWinnersByMaxPosition(int maxPosition) {
        return this.cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(winner -> winner.getName())
                .collect(Collectors.joining(", "));
    }

    private int getMaxPosition() {
        return this.cars.stream()
                .mapToInt(car -> car.getPosition())
                .max()
                .getAsInt();
    }
}
