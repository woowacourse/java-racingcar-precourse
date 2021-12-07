package racingcar.config;

import racingcar.view.input.InputCountView;
import racingcar.view.input.InputNameView;
import racingcar.view.input.InputView;

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
}
