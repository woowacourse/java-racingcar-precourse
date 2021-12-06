package racingcar.view;

import racingcar.domain.Cars;

public class InputView {



	private final InputStrategy inputStrategy;

	public InputView(InputStrategy inputStrategy) {
		this.inputStrategy = inputStrategy;
	}

	public ViewDto getCarsAndTryNumber() {

		Cars cars = inputStrategy.getCars();

		int tryNumber = inputStrategy.getTryNumber();
		return new ViewDto(cars, tryNumber);
	}

}