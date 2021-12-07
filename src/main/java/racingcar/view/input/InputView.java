package racingcar.view.input;

import racingcar.domain.car.CarSet;
import racingcar.domain.round.RacingRound;

public class InputView {

	private final InputNameView inputNameView;
	private final InputCountView inputCountView;

	public InputView(InputNameView inputNameView, InputCountView inputCountView) {
		this.inputNameView = inputNameView;
		this.inputCountView = inputCountView;
	}

	public CarSet inputCarSet() {
		return inputNameView.inputNames();
	}

	public RacingRound inputRacingRound() {
		return inputCountView.inputCount();
	}
}
