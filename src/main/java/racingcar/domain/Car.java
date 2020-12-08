package racingcar.domain;

import racingcar.validator.CarNameValidator;

public class Car {
    private static final int ZERO = 0;
    private static final int ONE = 1;

    private final String name;
    private int position = ZERO;

    public Car(String name) {
        CarNameValidator.validate(name);
        this.name = name;
    }

    public void forwardOneStep() {
        forward(ONE);
    }

    public void forward(int step) {
        if (step <= ZERO) {
            return;
        }
        position += step;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
