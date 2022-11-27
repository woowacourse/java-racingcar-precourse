package racingcar.domain.movables.cars;

import racingcar.domain.movables.engine.Movable;
import racingcar.domain.movestrategy.MoveStrategy;
import racingcar.domain.positive.Positive;

public class Car implements Movable {
    private final CarName name;
    private Positive carPosition;
    
    public Car(String name) {
        this.name = new CarName(name);
        this.carPosition = new Positive();
    }
    
    @Override
    public void move(final MoveStrategy moveStrategy) {
        if (moveStrategy.isMovable()) {
            carPosition = carPosition.increase();
        }
    }
    
    @Override
    public String name() {
        return name.name();
    }
    
    @Override
    public int position() {
        return carPosition.number();
    }
    
    @Override
    public String toString() {
        return "Car{" +
                "name=" + name +
                ", carPosition=" + carPosition +
                '}';
    }
}
