package racingcar.Car;

public class Car {
    private static final int STOP_NUMBER = 3;
    private final String name;
    private int position = 0;

    protected Car(String name) {
        this.name = name;
    }

    public void race(int randomNumber) {
        if (randomNumber > STOP_NUMBER) {
            position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
