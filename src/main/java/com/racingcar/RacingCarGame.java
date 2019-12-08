package com.racingcar;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * RacingCarGame
 *
 * @author hyochan
 * @version 0.0.1
 * @since 2019-12-06
 */


public class RacingCarGame {
    private List<Car> cars;
    private int count;
    public Output output = new Output();

    public void randomAdvance(Car car) {
        int randNum = (int) (Math.random() * 10);
        if (randNum >= 4) {
            car.advance();
        }
    }
}
