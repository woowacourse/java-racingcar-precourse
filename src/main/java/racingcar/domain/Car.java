package racingcar.domain;

public class Car implements Comparable<Car>{

    private static final int MIN_NUMBER_OF_MOVE = 4;

    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void action(int randomValue) {
        if (randomValue >= MIN_NUMBER_OF_MOVE) {
            this.position++;
        }
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

    @Override
    public int compareTo(Car car) {
        return car.position - this.position;
    }
}
