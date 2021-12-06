package racingcar;

import static racingcar.Constant.*;

public class StringUtil {
	public static String[] splitUsingComma(String inputEveryCarsName) {
		Validator.hasNoCarNameAtLast(inputEveryCarsName);
		return inputEveryCarsName.split(CAR_SPLIT_REGEX);
	}
}

