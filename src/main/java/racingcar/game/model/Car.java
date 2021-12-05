package racingcar.game.model;

import java.util.Objects;

import racingcar.game.move.MovableStrategy;

public class Car {
    private final MovableStrategy movableStrategy;
    private final Name name;
    private Position position;

    public Car(Name name, MovableStrategy movableStrategy) {
        this.movableStrategy = movableStrategy;
        this.name = name;
        this.position = Position.ZERO;
    }

    public void attemptMoveThrough() {
        if (movableStrategy.isMovable()) {
            position = position.movePosition();
        }

    }

    public boolean isSamePosition(final int winnerPosition) {
        return position.getPosition() == winnerPosition;
    }

    public String getName() {
        return name.getName();
    }

    public int getPosition() {
        return position.getPosition();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Car car = (Car)o;
        return name.equals(car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

}
