package racingcar.domain;

public class Car {

    private final CarName carName;
    private final CarPosition carPosition;

    public Car(String name) throws IllegalArgumentException {
        this.carName = new CarName(name);
        this.carPosition = new CarPosition();
    }

    public void move(MoveStrategy moveStrategy) {
        if (moveStrategy.move()) {
            carPosition.moveForward();
        }
    }

    public int position() {
        return carPosition.position();
    }

    public String name() {
        return carName.name();
    }
}
