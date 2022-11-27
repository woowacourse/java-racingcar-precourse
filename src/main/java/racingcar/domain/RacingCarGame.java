package racingcar.domain;

import racingcar.domain.movables.engine.Movables;
import racingcar.domain.movables.engine.MovablesCreator;
import racingcar.domain.movables.factory.MovablesFactoryBean;
import racingcar.domain.positive.Positive;

public class RacingCarGame {
    private final Movables cars;
    private Positive numberOfMoves;
    
    public RacingCarGame(final String carsName, final int numberOfMoves) {
        final MovablesCreator movablesCreator = new MovablesFactoryBean().createMovablesCreator();
        this.cars = movablesCreator.create(carsName);
        this.numberOfMoves = new Positive(numberOfMoves);
    }
    
    public void racing() {
        cars.race();
        numberOfMoves = numberOfMoves.increase();
    }
}
