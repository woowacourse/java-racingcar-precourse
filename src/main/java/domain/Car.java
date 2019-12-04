package domain;

public class Car implements Comparable<Car> {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return this.position;
    }

    public void goForward() {
        this.position++;
    }

    @Override
    public String toString() {
        // TODO: getPosition() 대신 "-" * int 형식으로 출력
        return getName() + ": " + getPosition();
    }

    @Override
    public int compareTo(Car compared) {
        return compared.getPosition() - getPosition();
    }
}
