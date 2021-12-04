package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;

public class CarGame implements Runnable {
	private static final String GUIDE_INPUT_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	private static final String COMMA = ",";

	@Override
	public void run() {
		try {
			Arrays.stream(splitComma(trim(inputCarNames())))
				.forEach(name -> Cars.addCar(new Car(name)));
		} catch (IllegalArgumentException exception) {
			System.out.println(exception.getMessage());
		}
	}

	private String[] splitComma(String carNames) {
		return carNames.split(COMMA);
	}

	private String trim(String inputCarNames) {
		return inputCarNames.trim();
	}

	private String inputCarNames() {
		System.out.println(GUIDE_INPUT_CAR_NAME);
		return Console.readLine();
	}
}
