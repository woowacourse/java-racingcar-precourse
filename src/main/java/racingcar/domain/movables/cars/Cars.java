package racingcar.domain.movables.cars;

import racingcar.domain.movables.engine.Movable;
import racingcar.domain.movables.engine.Movables;
import racingcar.domain.movestrategy.RandomBasedMoveStrategy;
import racingcar.domain.winners.engine.Winners;

import java.util.List;

public class Cars implements Movables {
    private final List<Movable> cars;
    
    public Cars(final List<Movable> cars) {
        this.cars = cars;
    }
    
    @Override
    public void race() {
        cars.forEach(car -> car.move(new RandomBasedMoveStrategy()));
    }
    
    @Override
    public Winners winners() {
        return null;
    }
    
    @Override
    public List<Movable> movables() {
        return cars;
    }
}
