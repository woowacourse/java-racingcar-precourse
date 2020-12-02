package racingcar;

public class Car {

    private final int MOVE_FRONT_MIN = 4;

    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void move(int moveValue) {
        if (moveValue >= MOVE_FRONT_MIN) {
            moveFront();
        }
    }

    public void moveFront() {
        position++;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

}
