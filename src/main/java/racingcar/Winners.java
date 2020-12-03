package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class Winners {

    private final List<Car> winners;

    public Winners(List<Car> winners) {
        this.winners = winners;
    }

    public String getWinnerNames() {
        return winners.stream()
                .map(Object::toString)
                .collect(Collectors.joining(", "));
    }
}
