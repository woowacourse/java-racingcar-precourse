package racingcar.config;

import racingcar.view.input.InputCountView;
import racingcar.view.input.InputNameView;
import racingcar.view.input.InputView;
import racingcar.view.output.OutputInitView;
import racingcar.view.output.OutputProcessView;
import racingcar.view.output.OutputResultView;
import racingcar.view.output.OutputView;

public class ViewConfig {

	public static InputView getInputView() {
		return new InputView(getInputNameView(), getInputCountView());
	}

	public static InputNameView getInputNameView() {
		return new InputNameView(ClientConfig.getInputClient(), ClientConfig.getErrorClient());
	}

	public static InputCountView getInputCountView() {
		return new InputCountView(ClientConfig.getInputClient(), ClientConfig.getErrorClient());
	}

	public static OutputView getOutputView() {
		return new OutputView(getOutputInitView(), getOutputProcessView(), getOutputResultView());
	}

	public static OutputInitView getOutputInitView() {
		return new OutputInitView(ClientConfig.getOutputClient());
	}

	public static OutputProcessView getOutputProcessView() {
		return new OutputProcessView(ClientConfig.getOutputClient());
	}

	public static OutputResultView getOutputResultView() {
		return new OutputResultView(ClientConfig.getOutputClient());
	}
}
