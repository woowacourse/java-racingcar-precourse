package racingcar.domain;

import racingcar.domain.movables.engine.Movables;
import racingcar.domain.movables.engine.MovablesCreator;

import java.util.List;

public class RacingGame {
    private final Movables cars;
    private Positive numberOfMoves;
    
    public RacingGame(final String carsName, final MovablesCreator movablesCreator) {
        this(movablesCreator.create(carsName));
    }
    
    private RacingGame(final Movables cars) {
        this.cars = cars;
        this.numberOfMoves = new Positive();
    }
    
    public void race() {
        cars.race();
        numberOfMoves = numberOfMoves.increase();
    }
    
    public boolean isFinished(final int numberOfMoves) {
        return this.numberOfMoves.isSame(numberOfMoves);
    }
    
    public List<String> movablesName() {
        return cars.movablesName();
    }
    
    public List<Integer> movablesPosition() {
        return cars.movablesPosition();
    }
    
    public Winners winners() {
        return cars.winners();
    }
}
