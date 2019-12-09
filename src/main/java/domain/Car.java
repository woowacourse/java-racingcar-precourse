package domain;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void setPosition(int targetPosition) {
        position = targetPosition;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

}
