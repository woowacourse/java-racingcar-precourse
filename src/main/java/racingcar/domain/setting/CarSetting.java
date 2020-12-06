package racingcar.domain.setting;

public enum CarSetting {

    RANDOM_MAX_NUMBER(9)
    , RANDOM_MIN_NUMBER(0)
    , STAY(0)
    , MOVE(1)
    , REQUIRE_POWER(4)
    , NAME_MAX_LENGTH(5)
    ;

    private final int value;

    CarSetting(int value) {
        this.value = value;
    }

    public int get() {
        return value;
    }

    @Override
    public String toString() {
        return String.format("%s : %d", name(), get());
    }
}
