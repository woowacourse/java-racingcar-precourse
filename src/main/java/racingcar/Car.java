package racingcar;

public class Car {

    public static final int MIN_FUEL = 4;
    public static final int MAX_FUEL = 9;
    public static final int MAX_NAME_LENGTH = 5;

    private final String name;
    private int position = 0;

    public Car(String name) {
        validateName(name);
        this.name = name;
    }

    // 추가 기능 구현
    private void validateName(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차의 이름은 5자 이하여야 합니다.");
        }
    }


    public void moveOrStop(int fuel) {
        validateFuel(fuel);
        if (fuel >= MIN_FUEL) {
            move();
        }
    }

    private void validateFuel(int fuel) {
        if (fuel < 0 || fuel > MAX_FUEL) {
            throw new IllegalArgumentException("연료는 0 이상 9 이하의 값이어야 합니다.");
        }
    }

    private void move() {
        position++;
    }

    public int getCurrentPosition() {
        return position;
    }
}
