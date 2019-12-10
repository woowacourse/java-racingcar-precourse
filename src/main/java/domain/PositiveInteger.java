package domain;

public class PositiveInteger {
    private final int number;

    public PositiveInteger(String value) {
        this(Integer.parseInt(value));
    }

    public PositiveInteger(int number) {
        if (number < 1) {
            throw new RuntimeException("최소 1회는 시도해야 합니다.");
        }
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
