package racingcar.domain;

import java.util.List;

public class RacingGame {

    private final Cars cars;
    private int round;

    public RacingGame(Cars cars, int round) {
        this.cars = cars;
        this.round = round;
    }

    public static RacingGame createRandomCarRacing(List<String> names, String round) {
        return new RacingGame(Cars.createRandomCars(names), Integer.parseInt(round));
    }
}
