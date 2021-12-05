package racingcar.utils;

public enum NameLength {

    MAXIMUM(5);

    private final int number;

    NameLength(int number) {
        this.number = number;
    }

    public static int getMaximum() {
        return MAXIMUM.number;
    }

    public static boolean isTooLong(String name) {
        return (name.length() > getMaximum());
    }

}
