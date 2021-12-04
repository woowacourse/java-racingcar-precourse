package racingcar.domain;

import java.util.Collections;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class Result<T extends Raceable> {

    private final List<T> winners;

    public Result(List<T> competitors) {
        winners = findWinners(competitors);
    }

    private <T extends Raceable> List<T> findWinners(List<T> competitors) {
        T winner = Collections.max(competitors);
        return competitors.stream()
                .filter(competitor -> competitor.isSamePositionWith(winner))
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return winners.stream()
                .map(Raceable::getName)
                .collect(Collectors.joining(", "));
    }
}
