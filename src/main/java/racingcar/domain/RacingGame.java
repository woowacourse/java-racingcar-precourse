package racingcar.domain;

import java.util.List;
import racingcar.exception.RacingGameRoundIntegerException;

public class RacingGame {

    private static final String INTEGER_REGEX = "[0-9]+";

    private final Cars cars;
    private int round;

    public RacingGame(Cars cars, int round) {
        this.cars = cars;
        this.round = round;
    }

    public static RacingGame createRandomCarRacing(List<String> names, String round) {
        checkIntegerRound(round);
        return new RacingGame(Cars.createRandomCars(names), Integer.parseInt(round));
    }

    private static void checkIntegerRound(String round) {
        if (!round.matches(INTEGER_REGEX)) {
            throw new RacingGameRoundIntegerException();
        }
    }
}
