package racingcar.domain;

import java.util.Objects;

public class Car {

    private static final String CARS_NAME_EXCEPTION_MESSAGE = "[ERROR]: 자동차의 이름은 1글자 이상 5글자 이하로 지정하여야 합니다.";
    private static final Integer NAME_LENGTH_THRETHOLD = 5;

    private final String name;
    private int position = 0;

    public Car(String name) throws IllegalArgumentException {
        validCarName(name);
        this.name = name;
    }

    private void validCarName(String name) throws IllegalArgumentException {
        emptyNullCheck(name);
        validLength(name);
    }

    private void emptyNullCheck(String name) {
        if (Objects.isNull(name) || name.isEmpty()) {
            throw new IllegalArgumentException(CARS_NAME_EXCEPTION_MESSAGE);
        }
    }

    private void validLength(String name) {
        if (name.length() > NAME_LENGTH_THRETHOLD) {
            throw new IllegalArgumentException(CARS_NAME_EXCEPTION_MESSAGE);
        }
    }

    public void move(MoveStrategy moveStrategy) {
        if (moveStrategy.move()) {
            position++;
        }
    }

    public int position() {
        return position;
    }

    public String name() {
        return name;
    }
}
