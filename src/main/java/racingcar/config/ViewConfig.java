package racingcar.config;

import racingcar.view.input.InputNameView;
import racingcar.view.input.InputView;

public class ViewConfig {

	public static InputView getInputView() {
		return new InputView(getInputNameView());
	}

	public static InputNameView getInputNameView() {
		return new InputNameView(ClientConfig.getInputClient(), ClientConfig.getErrorClient());
	}
}
