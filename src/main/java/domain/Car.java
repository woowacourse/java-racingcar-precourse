package domain;

public class Car implements Comparable<Car> {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void moveForward(int position) {
        this.position += position;
    }

    @Override
    public int compareTo(Car o) {
        if (this.position > o.position) {
            return 1;
        }
        if (this.position < o.position) {
            return -1;
        }
        return 0;
    }
}
