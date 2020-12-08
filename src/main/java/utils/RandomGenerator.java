package utils;

public class RandomGenerator {
    private final static int MIN_NUM = 0;
    private final static int MAX_NUM = 9;

    public static int generate() {
        return RandomUtils.nextInt(MIN_NUM, MAX_NUM);
    }
}
