package racingcar.domain;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        checkNameLength(name);
        this.name = name;
    }

    private static void checkNameLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("Car의 이름은 5자 이하만 입력되어야 합니다.");
        }
    }
}
