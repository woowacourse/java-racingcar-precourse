package racingcar.domain;

public class Car implements Comparable<Car> {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void addPosition() {
        position++;
    }

    @Override
    public int compareTo(Car o) {
        return o.getPosition() - this.position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
