package racingcar.view;

import static racingcar.constant.GameConstants.Delimiter.*;
import static racingcar.constant.GameConstants.UserInputHint.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;
import racingcar.validator.UserInputValidator;

public class InputView {
	public static List<Car> inputNameList() throws IllegalArgumentException {
		System.out.println(NAME_INPUT_HINT.getString());

		List<String> userInputNameList = Arrays.asList(
			Console.readLine().split(USER_NAME_INPUT_DELIMITER.getString()));
		userInputNameList.forEach(UserInputValidator::validateUserInputNameLength);
		return userInputNameList.stream().map(Car::new).collect(Collectors.toList());
	}
}
