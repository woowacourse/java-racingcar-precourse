package racingcar.domain;

public class Car {

    private final CarName carName;
    private int position = 0;

    public Car(String name) throws IllegalArgumentException {

        this.carName = new CarName(name);
    }

    public void move(MoveStrategy moveStrategy) {
        if (moveStrategy.move()) {
            position++;
        }
    }

    public int position() {
        return position;
    }

    public String name() {
        return carName.name();
    }
}
