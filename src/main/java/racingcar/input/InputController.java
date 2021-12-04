package racingcar.input;

import java.util.List;

import racingcar.domain.Car;

public class InputController {

	private static final String CAR_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	private static final String TRIAL_INPUT_MESSAGE = "시도 횟수를 입력하세요.";

	public static List<Car> getCarNameInput() {
		System.out.println(CAR_NAME_INPUT_MESSAGE);
		return CarList.input();
	}

	public static int getTrialInput() {
		System.out.println(TRIAL_INPUT_MESSAGE);
		return Trial.input();
	}
}
