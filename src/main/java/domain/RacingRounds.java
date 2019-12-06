package domain;

public class RacingRounds {
    private int racingRounds;

    public RacingRounds(int racingRounds) throws IllegalArgumentException {
        validateNumberBounds(racingRounds);
        this.racingRounds = racingRounds;
    }

    private void validateNumberBounds(int racingRounds) {
        if (!(racingRounds > 0)) {
            throw new IllegalArgumentException();
        }
    }
}
