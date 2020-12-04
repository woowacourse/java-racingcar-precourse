package racingcar;

import org.junit.jupiter.api.Test;
import utils.CarsFactory;

import static org.junit.jupiter.api.Assertions.*;

class RacingGameTest {

    @Test
    void play() {
        String[] names = new String[] {"a","b","c","d"};
        int totalRound = 3;
        RacingGame racingGame = new RacingGame(CarsFactory.createCars(names), totalRound);
        racingGame.play();
    }
}