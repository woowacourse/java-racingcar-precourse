package racingcar.model;

public class Car {
    public static final int CAR_NAME_LENGTH_MAX = 5;
    public static final int CAR_NAME_LENGTH_MIN = 1;
    public static final int MOVEMENT_RANGE = 1;
    public static final int POSITION_INIT_VALUE = 0;
    public static final int STANDARD_VALUE_FOR_MOVE_FORWARD = 4;
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

        if (name.length() > CAR_NAME_LENGTH_MAX) {
            throw new IllegalArgumentException(ERROR_CAR_NAME_LENGTH_GREATER_THAN_FIVE);
        }

    }

    private void validateMinNameLength(String name) {

        if (name.length() < CAR_NAME_LENGTH_MIN) {
            throw new IllegalArgumentException(ERROR_CAR_NAME_LENGTH_LESS_THAN_ONE);
        }

    }

    public int getPosition() {
        return this.position;
    }

    public String getName() {
        return this.name;
    }

    public void moveForward(int randomNumber) {

        if (randomNumber >= STANDARD_VALUE_FOR_MOVE_FORWARD) {
            this.position += MOVEMENT_RANGE;
        }

    }
}
