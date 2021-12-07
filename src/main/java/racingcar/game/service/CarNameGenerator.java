package racingcar.game.service;

import racingcar.common.input.CarNameInput;
import racingcar.common.model.OutputContainer;
import racingcar.game.model.Cars;
import racingcar.game.model.CarsFactory;
import racingcar.game.move.RandomMovableStrategy;

public class CarNameGenerator {
	public static Cars generateCars() {
		while (true) {
			CarNameInput carNameInput = new CarNameInput();
			try {
				final String carName = carNameInput.receive();
				return CarsFactory.generate(carName, new RandomMovableStrategy());
			} catch (IllegalArgumentException e) {
				OutputContainer.printMessage(e.getMessage());
			}

		}

	}

}
