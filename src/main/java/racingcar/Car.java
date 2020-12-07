package racingcar;

public class Car {

    private final String name;
    private int position = GameManager.INITIALIZATION_INTEGER;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void forwardPosition() {
        position++;
    }
}
