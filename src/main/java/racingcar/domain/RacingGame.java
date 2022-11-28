package racingcar.domain;

import racingcar.domain.movables.engine.Movables;
import racingcar.domain.movables.engine.MovablesCreator;

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
    
    public void racing() {
        cars.race();
        numberOfMoves = numberOfMoves.increase();
    }
    
    public boolean isFinished(final int numberOfMoves) {
        return this.numberOfMoves.isSame(numberOfMoves);
    }
    
    public Winners winners() {
        return cars.winners();
    }
}
