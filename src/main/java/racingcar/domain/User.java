package racingcar.domain;

import static racingcar.util.Constant.*;

import camp.nextstep.edu.missionutils.Console;
import racingcar.util.Util;
import racingcar.util.Validation;

public class User {

	public String[] replyCars() {
		System.out.println(REPLY_CARS);
		String[] cars = Util.splitCars(Console.readLine());
		try {
			Validation.verifyCar(cars);
		} catch (IllegalArgumentException illegalArgumentException) {
			System.out.println(ERROR_PREFIX + illegalArgumentException.getMessage());
			return replyCars();
		}
		return cars;
	}

	public int replyMoveCount() {
		System.out.println(REPLY_MOVE);
		String moveCount = Console.readLine();
		try {
			Validation.verifyMove(moveCount);
		} catch (IllegalArgumentException illegalArgumentException) {
			System.out.println(ERROR_PREFIX + illegalArgumentException.getMessage());
			return replyMoveCount();
		}
		return Integer.parseInt(moveCount);
	}
}
