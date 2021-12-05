package racingcar.domain;

import java.util.List;
import racingcar.exception.RacingGameCannotRaceRoundException;
import racingcar.exception.RacingGameRoundIntegerException;
import racingcar.exception.RacingGameZeroRoundException;

public class RacingGame {

    private static final String INTEGER_REGEX = "[0-9]+";
    private static final int ZERO_ROUND = 0;

    private final Cars cars;
    private int round;

    public RacingGame(Cars cars, int round) {
        this.cars = cars;
        this.round = round;
    }

    public static RacingGame createRandomCarRacing(List<String> names, String stringRound) {
        checkIntegerRound(stringRound);
        int round = Integer.parseInt(stringRound);
        checkZeroRound(round);
        return new RacingGame(Cars.createRandomCars(names), round);
    }

    private static void checkIntegerRound(String round) {
        if (!round.matches(INTEGER_REGEX)) {
            throw new RacingGameRoundIntegerException();
        }
    }

    private static void checkZeroRound(int round) {
        if (round == ZERO_ROUND) {
            throw new RacingGameZeroRoundException();
        }
    }

    public void race() {
        checkCanRaceRound();
        round--;
        cars.move();
    }

    private void checkCanRaceRound() {
        if (round <= ZERO_ROUND) {
            throw new RacingGameCannotRaceRoundException();
        }
    }

    public List<Car> cars() {
        return cars.cars();
    }
}
