package dto;

import model.car.Car;

public class AttemptResult {
    private final String name;
    private final int position;

    public AttemptResult(final Car car) {
        this.name = car.getName();
        this.position = car.getPosition();
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
