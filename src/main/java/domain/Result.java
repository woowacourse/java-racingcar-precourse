package domain;

import utils.StringUtils;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Result {
    private List<Car> cars;

    Result(List<Car> cars) {
        this.cars = cars.stream()
                .map(Car::newInstance)
                .collect(Collectors.toList());
    }

    public String getResult() {
        return cars.stream()
                .map(car -> car.getName() + " : " + StringUtils.hyphenParser(car.getPosition()) + "\n")
                .collect(Collectors.joining());
    }

    public List<String> getWinners() {
        int positionMax = cars.stream()
                .map(Car::getPosition)
                .max(Comparator.naturalOrder())
                .orElseThrow(RuntimeException::new);

        return cars.stream()
                .filter(car -> car.getPosition() == positionMax)
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
