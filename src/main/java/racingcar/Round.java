package racingcar;

import racingcar.exception.RoundIllegalArgumentException;

public class Round {
    private final int round;

    public Round(String round) {
        this.round = validate(round);
    }

    public int validate(String round) {
        try {
            return Integer.parseInt(round);
        } catch (Exception e) {
            throw new RoundIllegalArgumentException();
        }
    }
}
