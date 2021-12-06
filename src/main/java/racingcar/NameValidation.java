package racingcar;

import java.util.List;
import java.util.regex.Pattern;

public class NameValidation {
	private static final Pattern pattern = Pattern.compile("([a-zA-Z가-힣0-9]{1,5},)+[a-zA-Z가-힣0-9]{1,5}");
	private static final String INVALID_MESSAGE = "올바르지 않은 입력입니다.";
	private static final String DUPLICATED_MESSAGE = "중복된 이름이 존재합니다.";

	public static void isValidateNames(String carNames) {
		if (!pattern.matcher(carNames).matches()) {
			throw new IllegalArgumentException(INVALID_MESSAGE);
		}
		return;
	}

	public static void isDuplicated(List<String> names) {
		if (names.stream().distinct().count() != names.size()) {
			throw new IllegalArgumentException(DUPLICATED_MESSAGE);
		}
		return;
	}
}
