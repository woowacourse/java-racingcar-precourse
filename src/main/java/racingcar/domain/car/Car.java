package racingcar.domain.car;

import static racingcar.domain.error.ErrorMessage.*;

public class Car {
    private static final int DEFAULT_POSITION = 0;
    private static final char NAME_BLANK = ' ';
    private static final int NAME_MAX_LENGTH = 5;
    private static final String NAME_MESSAGE_FORMAT = "%s : ";
    private static final int ZERO_INDEX = 0;
    private static final String MOVING_STICK = "-";

    private final String name;
    private final MovingPolicy movingPolicy;
    private int position = DEFAULT_POSITION;

    public Car(String name, MovingPolicy movingPolicy) {
        validateName(name);
        this.name = name;
        this.movingPolicy = movingPolicy;
    }

    private void validateName(String name) {
        validateEmpty(name);
        validateBlank(name);
        validateLength(name);
    }

    private void validateEmpty(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException(CAR_NAME_EMPTY.getMessage());
        }
    }

    private void validateBlank(String name) {
        for (char c : name.toCharArray()) {
            if (c != NAME_BLANK) {
                return;
            }
        }
        throw new IllegalArgumentException(CAR_NAME_BLANK.getMessage());
    }

    private void validateLength(String name) {
        if (name.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(CAR_NAME_OVER_LENGTH.getMessage());
        }
    }

    protected void move() {
        if (movingPolicy.isMoving()) {
            position++;
        }
    }

    protected String getStateMessage() {
        StringBuilder stringBuilder = new StringBuilder(String.format(NAME_MESSAGE_FORMAT, name));
        for (int i = ZERO_INDEX; i < position; i++) {
            stringBuilder.append(MOVING_STICK);
        }
        return stringBuilder.toString();
    }

    protected String getName() {
        return name;
    }

    protected int getPosition() {
        return position;
    }

    protected boolean isSamePosition(int maxPosition) {
        if (this.position == maxPosition) {
            return true;
        }
        return false;
    }
}