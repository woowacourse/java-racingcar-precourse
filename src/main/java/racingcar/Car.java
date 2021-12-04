package racingcar;

public class Car {

    private static final int BOUND = 4;
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void goOrStop(int randomNumber) {
        if (randomNumber >= BOUND) {
            this.position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
