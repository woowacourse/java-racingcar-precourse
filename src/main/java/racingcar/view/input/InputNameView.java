package racingcar.view.input;

import java.util.List;
import java.util.stream.Collectors;

import racingcar.client.ErrorClient;
import racingcar.client.InputClient;
import racingcar.domain.car.Car;
import racingcar.domain.car.CarSet;
import racingcar.utils.StringUtils;

public class InputNameView {
	private static final String PROMPT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	private static final String SPLIT_DELIMITER = ",";

	private final InputClient inputClient;
	private final ErrorClient errorClient;

	public InputNameView(InputClient inputClient, ErrorClient errorClient) {
		this.inputClient = inputClient;
		this.errorClient = errorClient;
	}

	public CarSet inputNames() {
		try {
			return tryInputNames();
		} catch (IllegalArgumentException exception) {
			errorClient.error(exception.getMessage());
			return inputNames();
		}
	}

	private CarSet tryInputNames() throws IllegalArgumentException {
		return new CarSet(toCarList(inputClient.input(PROMPT)));
	}

	private List<Car> toCarList(String input) {
		List<String> names = StringUtils.toList(input, SPLIT_DELIMITER);
		return names.stream().map(Car::new).collect(Collectors.toList());
	}
}
