package racingcar.car;

public class Car {
    private static final int DEFAULT_POSITION = 0;
    private static final int NAME_MAX_LENGTH = 5;

    private final String name;
    private int position = DEFAULT_POSITION;

    public Car(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        validateLength(name);
    }

    private void validateLength(String name) {
        if (name.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException();
        }
    }
}