package domain;

public class Car {

    private final String name;
    private int position = ConstValue.START_POSITION;

    public Car(String name) {
        this.name = name;
    }

    public void moveCarPosition() {
        this.position += ConstValue.MOVE_DISTANCE;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}