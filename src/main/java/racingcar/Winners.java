package racingcar;

import domain.Car;

import java.util.List;
import java.util.stream.Collectors;

public class Winners {
    private List<Car> winners;

    public Winners(List<Car> winners) {
        this.winners = winners;
    }

    public List<String> getWinnersName(){
        return winners.stream()
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
