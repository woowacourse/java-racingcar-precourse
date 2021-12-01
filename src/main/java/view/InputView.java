package view;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Console;
import domain.Car;
import domain.MoveCount;

public class InputView {
	private static final String NAME_DELIMITER = ",";

	public static List<Car> inputCarNames() {
		OutputView.printInputCarNames();

		try {
			String input = Console.readLine();
			return Arrays.stream(input.split(NAME_DELIMITER))
				.map(Car::new)
				.collect(Collectors.toList());
		} catch (IllegalArgumentException e) {
			OutputView.printErrorMessage(e.getMessage());
			return inputCarNames();
		}
	}

	public static MoveCount inputMoveCount() {
		OutputView.printInputMoveCount();

		try {
			String input = Console.readLine();
			return MoveCount.from(input);
		} catch (IllegalArgumentException e) {
			OutputView.printErrorMessage(e.getMessage());
			return inputMoveCount();
		}
	}
}
