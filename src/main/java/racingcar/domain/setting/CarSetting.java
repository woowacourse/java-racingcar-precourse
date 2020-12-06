package racingcar.domain.game;

public enum CarSetting {

    RANDOM_MAX_NUMBER(9)
    , RANDOM_MIN_NUMBER(0)
    , STAY(0)
    , MOVE(1)
    , REQUIRE_POWER(4);

    private final int digit;

    CarSetting(int digit) {
        this.digit = digit;
    }

    public int get() {
        return digit;
    }

    @Override
    public String toString() {
        return String.format("%s : %d", name(), get());
    }
}
