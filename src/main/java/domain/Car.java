package domain;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void goForward() {
        this.position++;
    }

    private String getName() {
        return name;
    }

    private int getPosition() {
        return this.position;
    }

    @Override
    public String toString() {
        // TODO: getPosition() 대신 "-" * int 형식으로 출력
        return getName() + ": " + getPosition();
    }
}
