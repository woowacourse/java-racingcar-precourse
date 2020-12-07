package racingcar;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public int getPositon() {
        return position;
    }

    public void setPosition() {
        position++;
    }
}
