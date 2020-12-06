package racingcar.type;

/**
 * ValueType.java : 값 상수를 모아둔 Enum 클래스
 *
 * @author Daeun Lee
 * @version 1.0
 */
public enum ValueType {
    ZERO(0);

    private final int value;

    ValueType(int value) {
        this.value = value;
    }

    /**
     * @return 값 상수
     */
    public int getValue() {
        return value;
    }
}
