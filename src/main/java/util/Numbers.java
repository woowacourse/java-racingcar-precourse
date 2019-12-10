package util;

public class Numbers {
    private static final int RANGE = 10;

    public static int getRandomNumber() {
        return (int) (Math.random() * RANGE);
    }
}
