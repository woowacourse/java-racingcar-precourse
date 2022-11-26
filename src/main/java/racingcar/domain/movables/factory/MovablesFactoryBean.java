package racingcar.domain.movables.factory;

import racingcar.domain.movables.cars.CarCreator;
import racingcar.domain.movables.cars.CarsCreator;
import racingcar.domain.movables.engine.MovablesCreator;

public class MovablesFactoryBean {
    public MovablesCreator createMovablesCreator() {
        return new CarsCreator(new CarCreator());
    }
}
