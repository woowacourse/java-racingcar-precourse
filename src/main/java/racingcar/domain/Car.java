package racingcar.domain;

public class Car {
    private static final int MAX_NAME_LENGTH = 5;
    private final String name;
    private int position = 0;

    public Car(String name) {
        checkNameLength(name);
        this.name = name;
    }

    // 추가 기능 구현
    private void checkNameLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 자동차의 이름은 5자 이하여야 합니다. 현재 자동차 이름 = " + name);
        }
    }

    public boolean attemptMove(int number) {
        if (isMovable(number)) {
            position++;
            return true;
        }
        return false;
    }

    private boolean isMovable(int number) {
        return number >= 4;
    }

    public int getPosition() {
        return position;
    }
}
