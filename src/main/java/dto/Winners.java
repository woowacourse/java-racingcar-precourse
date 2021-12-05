package dto;

import java.util.List;
import java.util.stream.Collectors;

import model.car.Car;

public class Winners {
    private final List<String> winnerNames;

    public Winners(List<Car> winners) {
        winnerNames = winners.stream()
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    public List<String> getWinnerNames() {
        return winnerNames;
    }
}
