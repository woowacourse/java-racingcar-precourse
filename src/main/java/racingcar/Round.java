package racingcar;

public class Round {
    private final int round;

    public Round (String round) {
        this.round = validate(round);
    }
}
