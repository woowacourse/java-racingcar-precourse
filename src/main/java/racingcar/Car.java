package racingcar;

public class Car {
    private static final int ZERO = 0;
    private static final int ONE = 1;

    private final String name;
    private int position = ZERO;

    public Car(String name) {
        this.name = name;
    }

    public void forwardOneStep() {
        forward(ONE);
    }

    private void forward(int step) {
        position += step;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
