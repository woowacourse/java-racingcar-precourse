package racingcar.domain;

public class Engine {
    public static final int MIN_STANDARD_NUMBER = 4;

    private final int number;

    public Engine(int number) {
        this.number = number;
    }

    public boolean canOperate() {
        return number >= MIN_STANDARD_NUMBER;
    }
}
