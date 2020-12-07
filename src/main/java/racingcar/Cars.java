package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private List<Car> cars;

    Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void moveCarsAndPrintResult() {
        cars.stream().forEach(car -> car.moveAndPrintResult());
    }

    public List<String> getWinners() {
        int maxPosition = cars.stream()
            .map(car -> car.getPosition())
            .mapToInt(x -> x)
            .max()
            .getAsInt();
        return cars.stream()
            .filter(car -> car.getPosition() == maxPosition)
            .map(car -> car.getName())
            .collect(Collectors.toList());
    }
}
