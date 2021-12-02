package racingcar.car;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void moveForward() {
        this.position += CarService.GO_FORWARD_DISTANCE;
    }
}
