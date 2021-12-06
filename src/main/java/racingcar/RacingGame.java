package racingcar;

import static racingcar.utils.StringUtils.MIN_VALUE_OF_ROUND_NUMBER;
import static racingcar.utils.StringUtils.NUMBER_FOR_NO_ROUNDS_LEFT;

import java.util.List;

import racingcar.car.Car;
import racingcar.gameresult.RacingGameResult;
import racingcar.gameresult.RacingResults;

public class RacingGame {
    private final RacingGameResult racingGameResult;
    private int leftNumberOfRounds;

    private RacingGame(int leftNumberOfRounds) {
        this.leftNumberOfRounds = leftNumberOfRounds;
        racingGameResult = new RacingGameResult(leftNumberOfRounds);
    }

    public static RacingGame create(int numberOfRounds) {
        validateRoundNumber(numberOfRounds);
        return new RacingGame(numberOfRounds);
    }

    private static void validateRoundNumber(int number) {
        if (number < MIN_VALUE_OF_ROUND_NUMBER) {
            throw new IllegalArgumentException();
        }
    }

    public void completeOneRound() {
        leftNumberOfRounds--;
    }

    public boolean isOver() {
        if (leftNumberOfRounds <= NUMBER_FOR_NO_ROUNDS_LEFT) {
            return true;
        }
        return false;
    }

    public void recordRacingResults(List<Car> carsAfterRacing) {
        racingGameResult.add(new RacingResults(carsAfterRacing));
    }

    public RacingGameResult showGameResult() {
        return racingGameResult;
    }
}
