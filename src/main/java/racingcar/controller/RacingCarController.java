package racingcar.controller;

import racingcar.view.InputStrategy;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import racingcar.view.ViewDto;

public class RacingCarController {
	InputView inputView;
	OutputView outputView;
	InputStrategy inputStrategy;

	public RacingCarController(InputView inputView, OutputView outputView, InputStrategy inputStrategy) {
		this.inputView = inputView;
		this.outputView = outputView;
		this.inputStrategy = inputStrategy;
	}

	public void run() {
		ViewDto viewDto = InputView.input(inputStrategy);
		OutputView.printResult(viewDto);
	}
}
