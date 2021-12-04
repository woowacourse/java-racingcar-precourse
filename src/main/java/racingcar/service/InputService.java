package racingcar.service;

import camp.nextstep.edu.missionutils.Console;
import racingcar.Verification;

public class InputService {

	static final String INPUT_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

	public String[] readCarNames() {
		String[] carNames;

		while (true) {
			try {
				System.out.println(INPUT_CAR_NAME_MESSAGE);
				carNames = separateNames();
				break;
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}

		return carNames;
	}

	private String[] separateNames() throws IllegalArgumentException{
		String[] carNames = Console.readLine().split(",");

		for (String carName : carNames) {
			Verification.ofCarName(carName);
		}

		return carNames;
	}
}
