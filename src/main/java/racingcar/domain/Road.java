package racingcar.domain;


public class Road {
    private static final int MOVE_MIN_VALUE = 4;

    public void move(Car car, int number) {
        if (number >= MOVE_MIN_VALUE) {
            car.addPosition();
        }
    }
}
