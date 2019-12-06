package domain.car;

import domain.car.engine.Engine;

import java.util.Objects;

public class Car {
    private static final int NEED_POWER = 4;

    private final Name name;
    private int position = 0;

    public Car(String name) {
        this.name = new Name(name);
    }

    public void move(Engine engine) {
        int power = engine.getPower();
        if (enough(power)) {
            this.position++;
        }
    }

    private boolean enough(int power) {
        return power >= NEED_POWER;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name.getName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return position == car.position &&
                Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
