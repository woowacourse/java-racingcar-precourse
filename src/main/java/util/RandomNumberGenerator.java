package util;

public class RandomNumberGenerator {
    private static final int RANGE = 10;

    public static int getRandomNumber() {
        return (int) (Math.random() * RANGE);
    }
}
