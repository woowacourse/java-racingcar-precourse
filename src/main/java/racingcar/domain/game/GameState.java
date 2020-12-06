package racingcar.domain.game;

import racingcar.domain.exception.RacingTryCountsNumberFormatException;

import java.util.Iterator;
import java.util.stream.Stream;

public class GameState {
    private static final int MINIMUM_RACING_TRY_COUNTS = 1;
    private static final int EMPTY_VALUE = 0;

    private final Iterator<Integer> racingTryCounts;

    private GameState(Iterator<Integer> racingTryCounts) {
        this.racingTryCounts = racingTryCounts;
    }

    public static GameState initiate(int racingTryCounts) {
        validateRacingTryCounts(racingTryCounts);
        Iterator<Integer> racingTryCountsIterator = Stream.generate(() -> EMPTY_VALUE)
                .limit(racingTryCounts)
                .iterator();
        return new GameState(racingTryCountsIterator);
    }

    private static void validateRacingTryCounts(int racingTryCounts) {
        if (racingTryCounts < MINIMUM_RACING_TRY_COUNTS) {
            throw new RacingTryCountsNumberFormatException();
        }
    }
}
