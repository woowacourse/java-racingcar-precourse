package racingcar.domain.movables.cars;

import racingcar.domain.movables.engine.Movable;
import racingcar.domain.movables.engine.MovableCreator;
import racingcar.domain.movables.engine.Movables;
import racingcar.domain.movables.engine.MovablesCreator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarsCreator implements MovablesCreator {
    private static final String COMMA_DELIMITER = ",";
    
    private final MovableCreator movableCreator;
    
    public CarsCreator(final MovableCreator movableCreator) {
        this.movableCreator = movableCreator;
    }
    
    @Override
    public Movables create(final String movablesName) {
        return new Cars(parseCars(movablesName));
    }
    
    private List<Movable> parseCars(final String movablesName) {
        return Arrays.stream(split(movablesName))
                .map(movableCreator::create)
                .collect(Collectors.toUnmodifiableList());
    }
    
    private String[] split(final String movablesName) {
        return movablesName.split(COMMA_DELIMITER);
    }
}
