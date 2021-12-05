package racingcar.game.model;

import java.util.stream.Collectors;

import racingcar.common.utils.StringUtil;
import racingcar.game.move.MovableStrategy;

public class CarsFactory {
	public static Cars generate(final String carName, MovableStrategy movableStrategy) {
		return new Cars(StringUtil.split(carName).stream()
		.map(Name::new)
		.map(name -> new Car(name, movableStrategy))
		.collect(Collectors.toList()));
	}

}
