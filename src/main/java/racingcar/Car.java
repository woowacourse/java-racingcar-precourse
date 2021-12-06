package racingcar;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public Car updatePosition() {
        this.position += 1;
        return this;
    }
}
