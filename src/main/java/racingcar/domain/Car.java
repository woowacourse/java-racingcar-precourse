package racingcar.domain;

public class Car {
    private final CarName name;
    private int position = 0;

    public Car(final CarName name) {
        this.name = name;
    }

    public Car(final String name) {
        this(new CarName(name));
    }

    public String getName() {
        return name.getCarName();
    }

    public int getPosition() {
        return position;
    }
}
