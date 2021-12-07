package racingcar.iomanagement;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import racingcar.Car;
import racingcar.CarManager;
import racingcar.constant.Message;

public class InputScanner {
	public String enterCarName() {
		System.out.println(Message.CAR_INPUT);
		return Console.readLine();
	}

	public String enterCount() {
		System.out.println(Message.NUMBER_OF_ATTEMPTS);
		return Console.readLine();
	}

	public String enterCountWithException() {
		String count = enterCount();
		try {
			Validator.validateCountType(count);
			Validator.validateCountZero(count);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			count = enterCountWithException();
		}
		return count;
	}
}
