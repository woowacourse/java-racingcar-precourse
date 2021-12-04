package racingcar;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {
	public static void validateNameLength(String name) {
		if (name.length() > Constant.NAME_MAX_LENGTH) {
			throw new IllegalArgumentException(Constant.NAME_MAX_LENGTH_EXCEED_ERROR_MESSAGE);
		}
	}

	public static void validateBlankName(String name){
		if (name.isEmpty()) {
			throw new IllegalArgumentException(Constant.NAME_MINIMUN_LENGTH_UNDER_ERROR_MESSAGE);
		}
	}

	public static void validateGameRound(int gameRound) {
		if (gameRound < Constant.MINIMUM_GAME_ROUND) {
			throw new IllegalArgumentException(Constant.MINIMUM_GAME_ROUND_UNDER_ERROR_MESSAGE);
		}
	}

	public static void validateDuplicateCars(List<Car> carList) {
		Set<Car> carSet = new HashSet<>(carList);
		if (carList.size() != carSet.size()) {
			throw new IllegalArgumentException(Constant.CAR_NAME_DUPLICATE_ERROR_MESSAGE);
		}
	}
}
