package racingcar.view.input;

import racingcar.domain.car.CarSet;

public class InputView {

	private final InputNameView inputNameView;

	public InputView(InputNameView inputNameView) {
		this.inputNameView = inputNameView;
	}

	public CarSet inputCarSet() {
		return inputNameView.inputNames();
	}
}
