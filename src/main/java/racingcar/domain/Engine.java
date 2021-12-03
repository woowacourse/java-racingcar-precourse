package racingcar.domain;

public class Engine {
    public static final int FORWARD_THRESHOLD_NUMBER = 4;

    private final int number;

    public Engine(int number) {
        this.number = number;
    }

    public boolean canOperate() {
        return number >= FORWARD_THRESHOLD_NUMBER;
    }
}
