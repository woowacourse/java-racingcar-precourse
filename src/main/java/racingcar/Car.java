package racingcar;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }
    public String getName() { return this.name; }
    public int getPosition() { return this.position; }
    public void moveForwardCar() { this.position++; }

    @Override
    public String toString() {
        String result = this.name + " : ";
        for (int i=0; i<this.position; i++) {
            result += "-";
        }
        return result;
    }
}
