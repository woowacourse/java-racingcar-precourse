package racingcar.iomanagement;

import java.util.List;
import java.util.stream.Collectors;

import racingcar.car.Car;
import racingcar.constant.Message;

public class OutputPrinter {
	public void printStepResult(Car car) {
		StringBuilder positionBlock = new StringBuilder();
		for (int i = 0; i < car.getPosition(); i++) {
			positionBlock.append(Message.BLOCK);
		}
		String stepResultMessage = String.format(Message.RESULT_OF_STEP, car.getName(), positionBlock);

		System.out.println(stepResultMessage);
	}

	public void printFinalWinner(List<Car> winnerCarList) {
		String winners = winnerCarList
			.stream()
			.map(Car::getName)
			.collect(Collectors.joining(", "));
		String finalWinnerMessage = String.format(Message.FINAL_WINNER, winners);

		System.out.println(finalWinnerMessage);
	}
}
