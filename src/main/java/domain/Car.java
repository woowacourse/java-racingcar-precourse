package domain;

public class Car {
    private final String name;
    private int position = 0;
    String marker = "-";

    public Car(String name) {
        this.name = name;
    }

    public String getCarName() {
        return name;
    }

    public int getCarPosition() {
        return position;
    }

    public void moveCarPosition() {
        position++;
    }

    public String printCarPosition() {
        return marker.repeat(position);
    }
}
