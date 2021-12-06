package racingcar.utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import racingcar.Car;

import static racingcar.utils.ConstantNum.*;

public class Validation {
	public static void LESS_MORE_NAME_ERROR(String [] carsArray) {
		for (int i = 0; i < carsArray.length; i++) {
			if (carsArray[i].length() < CAR_NAME_LENGTH_MIN || carsArray[i].length() > CAR_NAME_LENGTH_MAX) {
				throw new IllegalArgumentException(Message.LESS_MORE_NAME_ERROR);
			}
		}
	}

	public static void CONTAIN_SAME_NAME_ERROR(String [] carsArray) {
		Set<String> carsSet = new HashSet<String>();
		for (int i = 0; i < carsArray.length; i++) {
			carsSet.add(carsArray[i]);
		}

		if (carsSet.size() < carsArray.length) {
			throw new IllegalArgumentException(Message.CONTAIN_SAME_NAME_ERROR);
		}
	}

	public static void WHITE_SPACE_NAME_ERROR(String [] carsArray) {
		for (int i = 0; i < carsArray.length; i++) {
			if (carsArray[i].trim().isEmpty()) {
				throw new IllegalArgumentException(Message.WHITE_SPACE_NAME_ERROR);
			}
		}
	}

	public static void NON_NUMERIC_GAME_COUNT_ERROR(String stringGameCount) {
		for (int i = 0; i < stringGameCount.length(); i++) {
			if (stringGameCount.charAt(i) < STRING_GAME_COUNT_MIN || STRING_GAME_COUNT_MAX < stringGameCount.charAt(
					i)) {
				throw new NumberFormatException(Message.NON_NUMERIC_GAME_COUNT_ERROR);
			}
		}
	}

	public static void ZERO_GAME_COUNT_ERROR(String stringGameCount) {
		if (stringGameCount.equals(ZERO_GAME_COUNT)) {
			throw new NumberFormatException(Message.ZERO_GAME_COUNT_ERROR);
		}
	}
}
