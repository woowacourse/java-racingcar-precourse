package domain;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class RacingCarProcessor {
    private final int MIN_NUMBER = 0;
    private final int MAX_NUMBER = 10;

    public List<Integer> carMovementRandomGenerator(int tryTimes) {
        return ThreadLocalRandom.current()
                .ints(MIN_NUMBER, MAX_NUMBER)
                .limit(tryTimes)
                .boxed()
                .collect(Collectors.toList());
    }
}
