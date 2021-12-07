package racingcar.exception;

import static racingcar.constant.Constant.*;
import static racingcar.constant.Message.*;

import java.util.Arrays;

public class NameException {
	public static void checkNameException(String[] names) {
		checkEmpty(names);
		checkMaxLen(names);
		checkMinLen(names);
	}

	// 입력이 되지 않은 경우
	private static void checkEmpty(String[] names) {
		if (Arrays.stream(names).count() == 0) {
			throw new IllegalArgumentException(ERROR_NAME_MIN_LENGTH);
		}

	}

	//이름의 길이 5이하 확인
	private static void checkMaxLen(String[] names) {
		long check = Arrays.stream(names)
			.filter(name -> name.length() > MAX_NAME_LENGTH)
			.count();
		if (check > 0) {
			throw new IllegalArgumentException(ERROR_NAME_MAX_LENGTH);
		}

	}

	// 이름 최소 1자 이상
	private static void checkMinLen(String[] names) {
		long check = Arrays.stream(names)
			.filter(name -> name.length() < 1)
			.count();
		if (check > 0) {
			throw new IllegalArgumentException(ERROR_NAME_MIN_LENGTH);
		}

	}

}
