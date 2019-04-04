package racingcar.utils;

public class RandomNumberGenerator implements NumberGenerator {
    private static final int RANGE = 10;

    @Override
    public int getNumber() {
        return (int)(Math.random()*RANGE);
    }
}
