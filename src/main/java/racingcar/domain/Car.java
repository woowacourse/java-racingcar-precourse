package racingcar.domain;

public class Car {

    private static final int MOVE_STANDARD = 4;
    private static final int LENGTH = 5;

    private final String name;
    private int position = 0;

    public Car(String name) {
        validate(name);
        this.name = name;
    }

    // 추가 기능 구현

    public void tryMoveForward(int number) {
        if (canMove(number)) {
            moveForward();
        }
    }

    private boolean canMove(int number) {
        return number >= MOVE_STANDARD;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    private void moveForward() {
        this.position += 1;
    }

    private void validate(String name) {
        if (isOutOfBounds(name)) {
            throw new IllegalArgumentException("[ERROR] 이름의 길이가 올바르지 않습니다.");
        }
    }

    private boolean isOutOfBounds(String name) {
        return name.length() > LENGTH || name.length() == 0;
    }
}
