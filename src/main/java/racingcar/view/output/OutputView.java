package racingcar.view.output;

import racingcar.domain.car.CarSet;

public class OutputView {

	private final OutputInitView outputInitView;
	private final OutputProcessView outputProcessView;
	private final OutputResultView outputResultView;

	public OutputView(OutputInitView outputInitView,
		OutputProcessView outputProcessView,
		OutputResultView outputResultView) {
		this.outputInitView = outputInitView;
		this.outputProcessView = outputProcessView;
		this.outputResultView = outputResultView;
	}

	public void showInit() {
		outputInitView.showInit();
	}

	public void showProcess(CarSet carSet) {
		outputProcessView.showProcess(carSet);
	}

	public void showResult(CarSet carSet) {
		outputResultView.showResult(carSet);
	}
}
