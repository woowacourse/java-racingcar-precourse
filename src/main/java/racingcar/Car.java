package racingcar;

public class Car {
    private static final int NAME_MAX_LENGTH = 3;

    private final String name;
    private int position = 0;

    public Car(String name) {
        isValidName(name);
        this.name = name;
    }

    private void isValidName(String name) {
        if(name.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("각 자동차의 이름은 5자 이내로 입력되어야 합니다.");
        }
    }
}
