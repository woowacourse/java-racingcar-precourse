package racingcar.domain;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        validate(name);
        this.name = name;
    }

    public void move(int number) {
        if (number >= 4) {
            position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    private void validate(String name) {
        validateIsEmpty(name);
        validateContainBlank(name);
        validateLength(name);
    }

    private void validateIsEmpty(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    private void validateContainBlank(String name) {
        if (name.contains(" ")) {
            throw new IllegalArgumentException();
        }
    }

    private void validateLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException();
        }
    }
}
