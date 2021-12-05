package racingcar.controller;

import racingcar.view.InputStrategy;
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
		ViewDto viewDto = inputView.input();
		OutputView.printResult(viewDto);
	}
}
