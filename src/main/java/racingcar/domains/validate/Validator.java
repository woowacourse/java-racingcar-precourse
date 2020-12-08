package racingcar.domains.validate;

import racingcar.domains.error.RacingCarGameException;

public interface Validator<T> {
    void isValid(T object) throws RacingCarGameException;
}
