package racingcar;

import utils.RandomUtils;

public class Game {
    private final int MIN_RANDOM_NUMBER = 0;
    private final int MAX_RANDOM_NUMBER = 9;

    private void playSingleRound(Car car) {
        if (randomGameNumber() <= 4) {
            car.move();
        }
    }

    private int randomGameNumber() {
        return RandomUtils.nextInt(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
    }
}
