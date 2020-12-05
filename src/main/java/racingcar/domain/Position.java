package racingcar.domain;

import racingcar.domain.exception.RoundOutOfBoundsException;
import racingcar.domain.validator.RoundValidator;

public final class Position {

    private final int position;

    public Position(final int position) {
        if (position > RoundValidator.MAXIMUM_ROUND) {
            throw new RoundOutOfBoundsException();
        }

        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public Position increase() {
        return new Position(position + 1);
    }
}
