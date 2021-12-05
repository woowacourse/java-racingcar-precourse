package racingcar.controller;

import racingcar.view.InputView;
import racingcar.view.OutputView;
import racingcar.view.ViewDto;

public class RacingCarController {
	InputView inputView;
	OutputView outputView;

	public RacingCarController(InputView inputView, OutputView outputView) {
		this.inputView = inputView;
		this.outputView = outputView;
	}

	public void run() {
		ViewDto viewDto = inputView.getCarsAndTryNumber();
		OutputView.printResult(viewDto);
	}
}
