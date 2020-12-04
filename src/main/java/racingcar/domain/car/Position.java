package racingcar.domain.car;

public class Position {
    private static final int MIN_POSITION_NUMBER = 0;
    private static final String POSITION_NUMBER_MESSAGE = "[ERROR] 자동차의 위치는 0보다 작을 수 없습니다";

    private final int position;

    public Position(int position) {
        validatePosition(position);
        this.position = position;
    }

    private void validatePosition(int position) {
        if (position < MIN_POSITION_NUMBER) {
            throw new IllegalArgumentException(POSITION_NUMBER_MESSAGE);
        }
    }

    public Position nextPosition() {
        return new Position(position + 1);
    }

    public boolean isEqualTo(int position) {
        return this.position == position;
    }

    public int getValue() {
        return position;
    }
}
