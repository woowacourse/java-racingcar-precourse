package domain;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }


    public int showPosition() {
        return this.position;
    }

    public void move() {
        this.position++;
    }

    @Override
    public String toString() {
        return this.name;
    }


}
