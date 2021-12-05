package racingcar.view;

import racingcar.domain.Cars;

public class ViewDto {
	Cars cars;
	int tryNumber;

	public ViewDto(Cars cars, int tryNumber) {
		this.cars = cars;
		this.tryNumber = tryNumber;
	}
}
