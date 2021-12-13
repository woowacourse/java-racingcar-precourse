package racingcar;

import static racingcar.Constant.*;

public class StringUtil {
	public static String[] splitUsingComma(String inputEveryCarsName) {
		return inputEveryCarsName.split(CAR_SPLIT_REGEX,-1);
	}
}

