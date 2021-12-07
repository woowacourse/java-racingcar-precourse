package racingcar.domain;

public class Car {
    private int position = 0;

    private final String name;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

    public void move(Engine engine) {
        if (engine.getDigit() >= GO_FORWARD_NUM) {
            this.position += GO_FORWARD_DISTANCE;
        }
    }
}

