package enums;

public enum GameProcess {
    NO_TURN(0),
    INITIAL_POSITION(0),
    RANDOM_START_INCLUSIVE(0),
    RANDOM_END_INCLUSIVE(9),
    CRITERIA_TO_GO_OR_STOP(4),
    MAXIMUM_NAME_LENGTH(5);

    int value = -1;

    GameProcess(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
