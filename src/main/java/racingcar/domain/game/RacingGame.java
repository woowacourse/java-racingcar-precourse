package racingcar.domain.game;

import racingcar.domain.car.Cars;
import racingcar.domain.exception.RacingTryCountsNumberFormatException;

public class RacingGame {
    private static final int MINIMUM_RACING_TRY_COUNTS = 1;

    private final Cars cars;
    private final int racingTryCounts;

    public RacingGame(Cars cars, int racingTryCounts) {
        validateRacingTryCounts(racingTryCounts);
        this.cars = cars;
        this.racingTryCounts = racingTryCounts;
    }

    private void validateRacingTryCounts(int racingTryCounts) {
        if (racingTryCounts < MINIMUM_RACING_TRY_COUNTS) {
            throw new RacingTryCountsNumberFormatException();
        }
    }
}
