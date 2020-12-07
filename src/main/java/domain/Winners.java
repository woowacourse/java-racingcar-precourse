package domain;

import java.util.List;
import java.util.stream.Collectors;

public class Winners {
    private List<Car> winners;

    private Winners(List<Car> winners) {
        this.winners = winners;
    }

    public static Winners from(List<Car> winners) {
        return new Winners(winners);
    }

    public List<String> getWinnersName() {
        return winners.stream()
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
