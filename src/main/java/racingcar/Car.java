package racingcar;

public class Car {
    private final String name;
    private int position = 0;

    static final int MIN_NUMBER = 0;
    static final int MAX_NUMBER = 9;
    static final int BOUNDARY_NUMBER = 4;

    public Car(String name) {
        this.name = name;
    }

    public void move() {
        int randomNumber = NumberGenerator.generateRandomNumber(MIN_NUMBER, MAX_NUMBER);
        if (randomNumber >= BOUNDARY_NUMBER) {
            position++;
        }
    }
}
