package domain;

public class Car {
    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

    public int getRandomNum() {
        return (int) (Math.random() * 9);
    }

    public void moveForward() {
        this.position++;
    }

    public void race() {
        if (this.getRandomNum() >= 4) {
            this.moveForward();
        }
    }
}
