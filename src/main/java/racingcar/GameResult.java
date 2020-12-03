package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class GameResult {

    List<Car> winners;

    public GameResult(List<Car> winners) {
        this.winners = winners;
    }

    public String getWinnerNames() {
        return winners.stream()
                .map(Object::toString)
                .collect(Collectors.joining(", "));
    }
}
