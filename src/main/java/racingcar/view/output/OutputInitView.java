package racingcar.view.output;

import racingcar.client.OutputClient;

public class OutputInitView {
	private static final String INIT_MESSAGE = "실행 결과";

	private final OutputClient outputClient;

	public OutputInitView(OutputClient outputClient) {
		this.outputClient = outputClient;
	}

	public void showInit() {
		outputClient.output(INIT_MESSAGE);
	}
}
