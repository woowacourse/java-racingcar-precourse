package racingcar.view.output;

import racingcar.client.OutputClient;
import racingcar.domain.car.CarSet;

public class OutputProcessView {

	private final OutputClient outputClient;

	public OutputProcessView(OutputClient outputClient) {
		this.outputClient = outputClient;
	}

	public void showProcess(CarSet carSet) {
		outputClient.output(carSet + "\n");
	}
}
