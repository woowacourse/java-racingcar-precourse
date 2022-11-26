package racingcar.domain.movables.cars;

import racingcar.domain.movables.engine.Movable;

public class Car implements Movable {
    private final CarName name;
    private CarPosition carPosition;

    public Car(String name) {
        this.name = new CarName(name);
        this.carPosition = new CarPosition();
    }
    
    @Override
    public void move() {
        carPosition = carPosition.increase();
    }
    
    @Override
    public String name() {
        return name.name();
    }
    
    @Override
    public int position() {
        return carPosition.position();
    }
}
