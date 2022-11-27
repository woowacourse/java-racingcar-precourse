package racingcar.domain;

import racingcar.domain.movables.engine.Movables;
import racingcar.domain.movables.engine.MovablesCreator;
import racingcar.domain.movables.factory.MovablesFactoryBean;
import racingcar.domain.positive.Positive;

public class RacingCarGame {
    private final Movables cars;
    private Positive numberOfMoves;
    
    public RacingCarGame(final String carsName) {
        final MovablesCreator movablesCreator = new MovablesFactoryBean().createMovablesCreator();
        this.cars = movablesCreator.create(carsName);
        this.numberOfMoves = new Positive();
    }
    
    public void racing() {
        cars.race();
        numberOfMoves = numberOfMoves.increase();
    }
    
    public boolean isFinished(final int numberOfMoves) {
        return this.numberOfMoves.isSame(numberOfMoves);
    }
}
