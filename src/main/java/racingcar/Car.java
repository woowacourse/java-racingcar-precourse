package racingcar;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public void moveForward() {
        position += 1;
    }
}
