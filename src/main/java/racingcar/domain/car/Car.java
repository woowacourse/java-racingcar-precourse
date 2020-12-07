package racingcar.domain.car;

public class Car implements CarInterface {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    @Override
    public int drive() {
        return 0;
    }

    private boolean shouldGo() {
        return false;
    }

    public int getPosition() {
        return position;
    }
}
