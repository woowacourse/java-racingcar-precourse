package racingcar;

import static racingcar.error.ErrorMessage.*;
import java.util.Optional;
import racingcar.util.Assertions;

public class MoveCount {
    private static final int MAX_COUNT = 100;
    private static final int MIN_COUNT = 0;

    private final int count;

    public MoveCount(int count) {
        Assertions.throwExceptionIsTrue(count > MAX_COUNT, OVER_MAX);
        Assertions.throwExceptionIsTrue(count <= MIN_COUNT, UNDER_MIN);
        this.count = count;
    }

    public static Optional<MoveCount> Empty() {
        return Optional.empty();
    }

    public int getCount() {
        return this.count;
    }
}
