package racingcar.domain.movables.cars;

import racingcar.domain.movables.engine.Movable;
import racingcar.domain.movables.engine.MovableCreator;

public class CarCreator implements MovableCreator {
    @Override
    public Movable create(final String movableName) {
        return new Car(movableName);
    }
}
