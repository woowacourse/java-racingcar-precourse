package racing.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Winner {
    private final List<Car> winners;

    private Winner(List<Car> winners) {
        this.winners = winners;
    }

    public static Winner of(List<Car> winners) {
        return new Winner(winners);
    }

    public String getCarNames() {
        return winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
    }
}
