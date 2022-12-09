package racingcar.domain;

public class Car {

    private static final int LENGTH = 5;

    private final String name;
    private int position = 0;

    public Car(String name) {
        validate(name);
        this.name = name;
    }

    // 추가 기능 구현
    private void validate(String name) {
        if (isOutOfBounds(name)) {
            throw new IllegalArgumentException("[ERROR] 이름이 5자가 넘습니다.");
        }
    }

    private boolean isOutOfBounds(String name) {
        return name.length() > LENGTH;
    }

}
