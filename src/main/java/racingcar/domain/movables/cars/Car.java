package racingcar.domain.movables.cars;

import racingcar.domain.Positive;
import racingcar.domain.movables.engine.Movable;
import racingcar.domain.movestrategy.MoveStrategy;

public class Car implements Movable {
    private final CarName carName;
    private Positive carPosition;
    
    public Car(String carName) {
        this.carName = new CarName(carName);
        this.carPosition = new Positive();
    }
    
    @Override
    public void move(final MoveStrategy moveStrategy) {
        if (moveStrategy.isMovable()) {
            carPosition = carPosition.increase();
        }
    }
    
    @Override
    public boolean isPositionSame(final int maxPosition) {
        return carPosition.isSame(maxPosition);
    }
    
    @Override
    public String name() {
        return carName.name();
    }
    
    @Override
    public int position() {
        return carPosition.number();
    }
    
    @Override
    public String toString() {
        return "Car{" +
                "name=" + carName +
                ", carPosition=" + carPosition +
                '}';
    }
}
