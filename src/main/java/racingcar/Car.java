package racingcar;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }
    public String getName() { return this.name; }
    public int getPosition() { return this.position; }
    public void moveForward() { this.position++; }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(this.name + " : ");
        for (int i=0; i<this.position; i++) {
            result.append("-");
        }
        return result.toString();
    }
}
