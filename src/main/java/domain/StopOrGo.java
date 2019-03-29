package domain;

public enum StopOrGo {
    GO, STOP;

    private static final int GO_UPPER_BOUND = 9;
    private static final int GO_LOWER_BOUND = 4;
    private static final int STOP_UPPER_BOUND = 3;
    private static final int STOP_LOWER_UPPER_BOUND = 0;

    static StopOrGo valueOf(int num) {
        if (num >= GO_LOWER_BOUND && num <= GO_UPPER_BOUND) {
            return GO;
        }
        if (num >= STOP_LOWER_UPPER_BOUND && num <= STOP_UPPER_BOUND) {
            return STOP;
        }
        throw new IllegalArgumentException("Invalid argument: " + num);
    }
}
