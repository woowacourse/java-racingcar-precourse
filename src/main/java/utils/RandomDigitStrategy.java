package utils;

public class RandomDigitStrategy implements DigitStrategy {
    private static final int MIN_RANDOM_DIGIT = 0;
    private static final int MAX_RANDOM_DIGIT = 9;

    @Override
    public int getDigit() {
        return RandomUtils.nextInt(MIN_RANDOM_DIGIT, MAX_RANDOM_DIGIT);
    }
}
