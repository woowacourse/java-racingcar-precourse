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
        if (name.contains(" ")) {
            throw new IllegalArgumentException("공백은 포함될 수 없습니다. 입력값 : " + name);
        }
    }

    private void validateNameLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차의 이름은 5자를 초과할 수 없습니다. 입력값 : " + name);
        }
    }
}
