package racingcar.exceptions;

import static racingcar.constant.NumberConstant.*;
import static racingcar.constant.StringConstant.*;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CarListException {
	public static void carListException(String[] carArray) {
		isEmpty(carArray);
		for (String car : carArray) {
			checkCarNameLength(car);
		}

		isCarNameOverlapped(carArray);
	}

	//"", ",,"와 같은 경우 예외처리
	private static void isEmpty(String[] carArray) {
		if (carArray.length < CAR_NAME_MIN_LENGTH) {
			throw new IllegalArgumentException(ERROR_PREFIX + CAR_NAME_NULL);
		}
	}

	//공백을 포함한 5자리보다 큰 이름의 자동차 예외처리
	//"  A6", "G 80"과 같은 입력은 예외X
	private static void checkCarNameLength(String car) {
		int carLength = car.length();
		if (carLength > CAR_NAME_MAX_LENGTH) {
			throw new IllegalArgumentException(ERROR_PREFIX + CAR_NAME_OVER);
		}

		isCarNameEmpty(car);
	}

	//"   "와 같은 입력은, 5자리 이하의 입력이지만 유효값(body)가 없어서 예외처리 필요
	private static void isCarNameEmpty(String car) {
		int carLengthWithoutSpace = car.trim().length();
		if (carLengthWithoutSpace < CAR_NAME_MIN_LENGTH) {
			throw new IllegalArgumentException(ERROR_PREFIX + CAR_NAME_NULL);
		}
	}

	private static void isCarNameOverlapped(String[] carArray) {
		int originLength = carArray.length;
		int distinctLength =
			Stream.of(carArray)
				.map(carName -> carName.trim())
				.distinct()
				.collect(Collectors.toList())
				.size();
		if (originLength != distinctLength) {
			throw new IllegalArgumentException(ERROR_PREFIX + CAR_NAME_OVERLAPPED);
		}
	}
}
