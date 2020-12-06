package racingcar.model;

public class Car {
    public static final int MAX_CAR_NAME_LENGTH = 5;
    public static final int MIN_CAR_NAME_LENGTH = 1;
    public static final int MOVEMENT_RANGE = 1;
    public static final int POSITION_INIT_VALUE = 0;
    public static final String ERROR_CAR_NAME_LENGTH_GREATER_THAN_FIVE = "[ERROR] 자동차 이름은 5자 이하여야 한다.";
    public static final String ERROR_CAR_NAME_LENGTH_LESS_THAN_ONE = "[ERROR] 자동차 이름은 1자 이상이여야 한다.";
    private final String name;
    private int position;

    public Car(String name) {
        validateMaxNameLength(name);
        validateMinNameLength(name);
        this.name = name;
        this.position = POSITION_INIT_VALUE;
    }

    private void validateMaxNameLength(String name) {

        if (name.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException(ERROR_CAR_NAME_LENGTH_GREATER_THAN_FIVE);
        }

    }

    private void validateMinNameLength(String name) {

        if (name.length() < MIN_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException(ERROR_CAR_NAME_LENGTH_LESS_THAN_ONE);
        }

    }

    public int getPosition() {
        return this.position;
    }

    public String getName() {
        return this.name;
    }

    public void moveFoward() {
        this.position += MOVEMENT_RANGE;
    }
}
