package racingcar.domain;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        validateNameLength(name);
        this.name = name;
    }

    private void validateNameLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름의 길이는 5자 이하만 가능합니다.");
        }
    }

    public int getPosition() {
        return position;
    }

    public void addPosition() {
        position++;
    }

    public String getName() {
        return name;
    }
}
