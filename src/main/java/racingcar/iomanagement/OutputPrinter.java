package racingcar.iomanagement;

import racingcar.Car;
import racingcar.constant.Message;

public class OutputPrinter {
	public String printStepResult(Car car) {
		return String.format(Message.RESULT_OF_STEP, car.getName(), car.getPosition());
	}
}
