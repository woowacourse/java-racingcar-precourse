package racingcar.domain;

import racingcar.exception.RacingGameCannotRaceRoundException;
import racingcar.exception.RacingGameRoundIntegerException;
import racingcar.exception.RacingGameZeroRoundException;

public class Round {

    private static final String INTEGER_REGEX = "[0-9]+";
    private static final int ZERO_ROUND = 0;

    private int round;

    private Round(int round) {
        this.round = round;
    }

    public static Round createByStringRound(String stringRound) {
        checkIntegerRound(stringRound);
        int round = Integer.parseInt(stringRound);
        checkZeroRound(round);
        return new Round(round);
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

    public void decreaseRound() {
        checkCanDecreaseRound();
        round--;
    }

    private void checkCanDecreaseRound() {
        if (round <= ZERO_ROUND) {
            throw new RacingGameCannotRaceRoundException();
        }
    }
}
