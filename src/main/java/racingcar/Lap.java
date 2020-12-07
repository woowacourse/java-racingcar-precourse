package racingcar;

public class Lap {

    private static final int ZERO = 0;

    private final int lap;
    private int currentLap = 0;

    private Lap(String lap) {
        int validateLap = validateInteger(lap);
        validateOverZero(validateLap);
        this.lap = validateLap;
    }

    public static Lap newLap(String lap) {
        return new Lap(lap);
    }

    private int validateInteger(String lap) {
        try {
            return Integer.parseInt(lap);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자여야 합니다.");
        }
    }

    private void validateOverZero(int lap) {
        if (lap <= ZERO) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }
    }

    public boolean isEnd() {
        return currentLap++ == lap;
    }
}
