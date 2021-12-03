package racingcar.exceptions;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CarListException {
	private static String ERROR_MESSAGE_OVER = "[ERROR] 자동차 이름은 공백을 포함하여 5자리를 넘을 수 없습니다.\n";
	private static String ERROR_MESSAGE_NULL = "[ERROR] 자동차 이름은 공백을 제외하고 최소 한자리 이상이어야 합니다.\n";
	private static String ERROR_MESSAGE_OVERLAPPED = "[ERROR] 자동차 이름은 중복될 수 없습니다.\n";


	public static void carListException(String[] carArray) {
		isEmpty(carArray);
		for (String car : carArray) {
			checkCarNameLength(car);
		}

		isCarNameOverlapped(carArray);
	}

	//"", ",,"와 같은 경우 예외처리
	private static void isEmpty(String[] carArray) {
		if (carArray.length == 0) {
			throw new IllegalArgumentException(ERROR_MESSAGE_NULL);
		}
	}

	//공백을 포함한 5자리보다 큰 이름의 자동차 예외처리
	//"  A6", "G 80"과 같은 입력은 예외X
	private static void checkCarNameLength(String car) {
		int carLength = car.length();
		if (carLength > 5) {
			throw new IllegalArgumentException(ERROR_MESSAGE_OVER);
		}

		isCarNameEmpty(car);
	}

	//"   "와 같은 입력은, 5자리 이하의 입력이지만 유효값(body)가 없어서 예외처리 필요
	private static void isCarNameEmpty(String car) {
		int carLengthWithoutSpace = car.trim().length();
		if (carLengthWithoutSpace == 0) {
			throw new IllegalArgumentException(ERROR_MESSAGE_NULL);
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
			throw new IllegalArgumentException(ERROR_MESSAGE_OVERLAPPED);
		}
	}
}
