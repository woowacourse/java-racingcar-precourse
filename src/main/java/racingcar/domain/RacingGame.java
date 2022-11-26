package racingcar.domain;

import racingcar.RandomNumberGenerator;

public class RacingGame {

    public void play(Cars cars) {
        cars.play(new RandomNumberGenerator());
    }
}
