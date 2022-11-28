package racingcar.domain.movables.cars;

import racingcar.domain.Winners;
import racingcar.domain.movables.engine.Movable;
import racingcar.domain.movables.engine.Movables;
import racingcar.domain.movestrategy.RandomBasedMoveStrategy;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

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
        return new Winners(parseWinners());
    }
    
    private List<Movable> parseWinners() {
        return cars.stream()
                .filter(car -> car.isPositionSame(maxPosition()))
                .collect(Collectors.toUnmodifiableList());
    }
    
    private int maxPosition() {
        return cars.stream()
                .mapToInt(Movable::position)
                .max()
                .orElseThrow(NoSuchElementException::new);
    }
    
    @Override
    public List<String> movablesName() {
        return cars.stream()
                .map(Movable::name)
                .collect(Collectors.toUnmodifiableList());
    }
    
    @Override
    public List<Integer> movablesPosition() {
        return cars.stream()
                .map(Movable::position)
                .collect(Collectors.toUnmodifiableList());
    }
}
