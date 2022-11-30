package racingcar.domain;

public class Car implements Comparable<Car>{

    private static final int POSITION_DEFAULT_VALUE = 0;
    private static final int MOVE_MINIMUM_CONDITION = 4;
    private static final String BLANK = " ";
    private static final int NAME_MAX_LENGTH = 5;

    private final String name;
    private int position;

    public Car(String name) {
        validate(name);
        this.name = name;
        this.position = POSITION_DEFAULT_VALUE;
    }

    public void move(int number) {
        if (number >= MOVE_MINIMUM_CONDITION) {
            position++;
        }
    }

    public boolean isSameName(Car other) {
        return name.equals(other.name);
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    private void validate(String name) {
        validateNameIsEmpty(name);
        validateNameContainBlank(name);
        validateNameLength(name);
    }

    private void validateNameIsEmpty(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("빈값은 포함될 수 없습니다. 입력값 : " + name);
        }
    }

    private void validateNameContainBlank(String name) {
        if (name.contains(BLANK)) {
            throw new IllegalArgumentException("공백은 포함될 수 없습니다. 입력값 : " + name);
        }
    }

    private void validateNameLength(String name) {
        if (name.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("자동차의 이름은 5자를 초과할 수 없습니다. 입력값 : " + name);
        }
    }

    @Override
    public int compareTo(Car other) {
        return this.position - other.position;
    }

    public boolean isSamePosition(Car maxPositionCar) {
        return position == maxPositionCar.position;
    }
}
