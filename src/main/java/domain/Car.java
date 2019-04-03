package domain;

public class Car {
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

    public void tryRide() {
        if (checkRide()) position++;
    }

    private boolean checkRide() {
        int ran = (int)(Math.random() * 10);
        return ran <= 4;
    }
}
