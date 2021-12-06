package racingcar.view;

import racingcar.model.RacingCars;

public class Output {

	static final String NAME_CONNECTION_POSITION_STRING=" : ";

	public void reportThisRoundResult(RacingCars racingCars) {
		racingCars.racingCars.forEach(
			car -> System.out.println(car.getName()+NAME_CONNECTION_POSITION_STRING+car.convertPositionIntToSymbol())
		);
		System.out.println();
	}
}
