package system;

import domain.Car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RankingSystem {
    private List<Car> racingCars;

    public RankingSystem(List<Car> racingCars) {
        this.racingCars = new ArrayList<>(racingCars);
    }

    public List<String> getWinner() {
        Collections.sort(racingCars);
        int maxPosition = racingCars.get(0).getPosition();
        return racingCars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(car -> car.getName())
                .collect(Collectors.toList());
    }
}
