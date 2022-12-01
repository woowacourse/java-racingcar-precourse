package racingcar.domain;

public class Car {

    private final String name;
    private int position = 0;
    private static final int MOVE_MIN_NUMBER = 4;

    public Car(String name) {
        this.name = name;
    }

    // 추가 기능 구현
    public boolean canMove(int number) {
        return number >= MOVE_MIN_NUMBER;
    }

    public void move() {
        position++;
    }

    public boolean isMaxPosition(int maxPosition) {
        return position == maxPosition;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
