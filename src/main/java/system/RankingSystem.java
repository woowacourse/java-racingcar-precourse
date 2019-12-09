package system;

import domain.Car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RankingSystem {
    private List<Car> cars;

    public RankingSystem(List<Car> cars) {
        this.cars = new ArrayList<>(cars);
    }

    public List<String> getWinner() {
        Collections.sort(cars);
        int maxPosition = cars.get(0).getPosition();
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(car -> car.getName())
                .collect(Collectors.toList());
    }
}
