package racingcar.domain.game;

import racingcar.domain.car.Cars;
import racingcar.domain.exception.RacingTryCountsNumberFormatException;

import java.util.Iterator;
import java.util.stream.Stream;

public class RacingGame {
    private static final int MINIMUM_RACING_TRY_COUNTS = 1;
    private static final int EMPTY_VALUE = 0;

    private final Cars cars;
    private final Iterator<Integer> racingTryCounts;

    public RacingGame(Cars cars, int racingTryCounts) {
        validateRacingTryCounts(racingTryCounts);
        this.cars = cars;
        this.racingTryCounts = Stream.generate(() -> EMPTY_VALUE)
                .limit(racingTryCounts)
                .iterator();
    }

    private void validateRacingTryCounts(int racingTryCounts) {
        if (racingTryCounts < MINIMUM_RACING_TRY_COUNTS) {
            throw new RacingTryCountsNumberFormatException();
        }
    }

    public void race() {
        decreaseRacingTryCounts();
        this.cars.move();
    }

    private void decreaseRacingTryCounts() {
        this.racingTryCounts.next();
    }

    public boolean isEnd() {
        return !this.racingTryCounts.hasNext();
    }
}
