package racingcar.iomanagement;

import racingcar.Car;
import racingcar.constant.Message;

public class OutputPrinter {
	public String printStepResult(Car car) {
		StringBuilder positionBlock = new StringBuilder();

		for (int i = 0; i < car.getPosition(); i++) {
			positionBlock.append(Message.BLOCK);
		}

		return String.format(Message.RESULT_OF_STEP, car.getName(), positionBlock);
	}
}
