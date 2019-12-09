package domain;

public class RacingRounds {
    private int racingRounds;

    public RacingRounds(int racingRounds) throws IllegalArgumentException {
        validateNumberBounds(racingRounds);
        this.racingRounds = racingRounds;
    }

    private void validateNumberBounds(int racingRounds) {
        if (!(racingRounds > 0)) {
            throw new IllegalArgumentException("시도할 회수는 양수만 가능합니다.");
        }
    }

    public void minus() {
        racingRounds--;
    }

    public boolean isLeft() {
        return racingRounds > 0;
    }
}
