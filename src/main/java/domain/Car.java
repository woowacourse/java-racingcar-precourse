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
        return  position;
    }

    public void setPosition(int newPosition) {
        position = newPosition;
    }

    public boolean tryRun() {
        int decidingNumber = (int)(Math.random() * 9 + 0);
        boolean isRun = false;

        if (decidingNumber > 3) {
            isRun = true;
        }

        return isRun;
    }
}
