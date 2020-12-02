package racingcar.domain.car;

public class Car {

    public static final int DEFAULT_POSITION = 0;

    private final String name;
    private int position;
    private CarMoveStrategy carMoveStrategy;

    private Car(final String name, final int position, final CarMoveStrategy carMoveStrategy) {
        this.name = name;
        this.position = position;
        this.carMoveStrategy = carMoveStrategy;
    }

    public static Car of(final String name, final CarMoveStrategy carMoveStrategy) {
        return new Car(name, DEFAULT_POSITION, carMoveStrategy);
    }

    public void move(final int value) {
        if (carMoveStrategy.isPossibleMove(value)) {
            this.position++;
        }
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }
}
