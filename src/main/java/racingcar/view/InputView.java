package racingcar.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import racingcar.utils.Validator;

public class InputView {

	public static void printCarInputMessage() {
		System.out.println(Message.INPUT_CAR_NAME.getMessage());
	}

	public static void inputCarName() {
		String carNames = Console.readLine();
		List<String> carNameList = Arrays.asList(carNames.split(","));
		if (Validator.checkCarNameLength(carNameList)) {
			System.out.println(carNames);
		}
	}
}
