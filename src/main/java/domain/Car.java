package domain;

public class Car implements Comparable<Car> {
    private static final int MOVE_NUMBER_FLOOR = 4;
    private static final int MAKING_ONE_TO_NINE = 10;
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void move() {
        if (makeRandomNumber() >= MOVE_NUMBER_FLOOR) {
            position++;
        }
    }

    private double makeRandomNumber() {
        double randomNumber = Math.random();

        return randomNumber * MAKING_ONE_TO_NINE;
    }

    public int getPosition() {
        return this.position;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public int compareTo(Car car) {
        return this.position - car.getPosition();
    }
}
