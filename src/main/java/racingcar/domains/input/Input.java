package racingcar.domains.input;

import racingcar.domains.error.RacingCarGameException;

public interface Input<T> {
    T get() throws RacingCarGameException;
}
