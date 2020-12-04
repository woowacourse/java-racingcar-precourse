package racingcar;

import org.junit.jupiter.api.Test;
import utils.CarsFactory;

import static org.junit.jupiter.api.Assertions.*;

class RacingGameTest {

    @Test
    void play() {
        Cars cars = CarsFactory.createCars(new String[]{"a","b","c"});
        Rounds totalRound = Rounds.initialize(3);
        RacingGame racingGame = new RacingGame(cars, totalRound);
        racingGame.play();
    }
}