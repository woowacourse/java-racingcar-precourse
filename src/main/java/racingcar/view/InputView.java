package racingcar.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;
import racingcar.utils.Validator;

public class InputView {
	public static void printCarNameInputMessage() {
		System.out.println(Message.INPUT_CAR_NAME.getMessage());
	}

	public static void inputCarName() {
		String carNames = Console.readLine();
		List<String> carNameList = Arrays.asList(carNames.split(","));
		if (Validator.checkCarNameLength(carNameList)) {
			// System.out.println(carNames);
			createCarInstance(carNameList);

		}
	}

	public static Car[] createCarInstance(List<String> carNameList) {
		Car[] carName = new Car[carNameList.size()];
		for (int i = 0; i < carNameList.size(); i++) {
			carName[i] = new Car(carNameList.get(i));
		}
		return carName;
	}

	public static void printAttemptInputMessage() {
		System.out.println(Message.INPUT_ATTEMPT_NUMBER.getMessage());
	}

	public static void inputAttemptNumber() {
		String tempInput = Console.readLine();
		if (Validator.checkAttemptNumber(tempInput)) {
			int attemptNumber = Integer.parseInt(tempInput);
			System.out.println(attemptNumber);
		}
	}
}
