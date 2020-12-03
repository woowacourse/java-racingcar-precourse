package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class GameResult {

    public GameResult(List<Car> winners) {
        this.winners = winners;
    }

    List<Car> winners;

    public void printWinners() {
        String results = winners.stream()
                .map(Object::toString)
                .collect(Collectors.joining(","));

        System.out.println(results);
    }

}
