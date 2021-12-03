package racingcar.utils.validator;

import java.util.Arrays;
import java.util.stream.Stream;

public class GameTimesValidator {
	public void validateTimes(String times) {
		String[] timesArray = times.split("");
		if(isEmptyString(timesArray)){
			throw new IllegalArgumentException("[ERROR] 시도 횟수는 빈 문자열이면 안된다.");
		}
		if(isContainNotNumber(timesArray)){
			throw new IllegalArgumentException("[ERROR] 시도 횟수는 숫자여야 한다.");
		}
		if (isZeroTimes(times)) {
			throw new IllegalArgumentException("[ERROR] 시도 횟수는 1 이상이어야 한다.");
		}
	}



	private boolean isEmptyString(String[] timesArray) {
		return Arrays.stream(timesArray)
			.anyMatch(character -> character.isEmpty());
	}

	private boolean isContainNotNumber(String[] timesArray) {
		return Arrays.stream(timesArray)
			.anyMatch(character -> character.charAt(0) < '0' || character.charAt(0) > '9');
	}

	private boolean isZeroTimes(String times) {
		if (Integer.parseInt(times) == 0) {
			return true;
		}
		return false;
	}
}
