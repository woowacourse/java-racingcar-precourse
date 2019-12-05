package domain;

public class Computer {
    private static final int RANGE_OF_NUMBER = 9;

    public static int makeRandomNumber() {
        return (int) (Math.random() * RANGE_OF_NUMBER);
    }

}
