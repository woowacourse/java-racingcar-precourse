package racingcar.view.output;

import java.util.stream.Collectors;

import racingcar.client.OutputClient;
import racingcar.domain.car.Car;
import racingcar.domain.car.CarSet;

public class OutputResultView {
	private static final String RESULT_PREFIX = "최종 우승자 : ";
	private static final String RESULT_DELIMITER = ", ";

	private final OutputClient outputClient;

	public OutputResultView(OutputClient outputClient) {
		this.outputClient = outputClient;
	}

	public void showResult(CarSet carSet) {
		outputClient.output(
			RESULT_PREFIX + carSet.getWinners().stream()
				.map(Car::getName)
				.collect(Collectors.joining(RESULT_DELIMITER))
		);
	}
}
