package racingcar.util;

import static racingcar.util.Constant.*;

import java.util.LinkedList;
import java.util.List;

public class Validation {

	public static void verifyCar(String[] cars) {
		List<String> temp = new LinkedList<>();
		for (String car :
			cars) {
			if (car.length() > NAME_LIMIT) {
				throw (new IllegalArgumentException("자동차의 이름은 5자 이하여야 한다."));
			}
			if (temp.contains(car)) {
				throw (new IllegalArgumentException("중복된 이름이 존재하면 안됩니다."));
			}
			if (car.equals("")) {
				throw (new IllegalArgumentException("빈칸의 이름은 허용하지 않습니다."));
			}
			temp.add(car);
		}
	}

	public static void verifyMove(String moveCount) {
		try {
			int count = Integer.parseInt(moveCount);
			if (count < 1) {
				throw (new IllegalArgumentException("시도 횟수는 1보다 크거나 같아야 합니다."));
			}
		} catch (NumberFormatException numberFormatException) {
			throw (new IllegalArgumentException("시도 횟수는 숫자여야 한다."));
		}
	}
}
