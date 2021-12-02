package model.car;

import model.car.vo.CarName;

public class Car {
    private static final int INITIAL_POSITION = 0;
    private final CarName name;
    private int position;

    public Car(final String name) {
        this.name = new CarName(name);
        position = INITIAL_POSITION;
    }

    public void move(final boolean move) {
        if (move) {
            position++;
        }
    }
}
