package domain;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void move() {
        this.position++;
    }

    public int getPosition() {
        return position;
    }
}
