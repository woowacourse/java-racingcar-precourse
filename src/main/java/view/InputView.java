package view;

import java.util.Arrays;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Console;
import domain.TryCount;
import domain.Name;
import domain.Names;

public class InputView {
	private static final String NAME_DELIMITER = ",";

	public static Names inputCarNames() {
		OutputView.printInputCarNames();

		try {
			String input = Console.readLine();
			return new Names(Arrays.stream(input.split(NAME_DELIMITER))
				.map(Name::new)
				.collect(Collectors.toList()));
		} catch (IllegalArgumentException e) {
			OutputView.printErrorMessage(e.getMessage());
			return inputCarNames();
		}
	}

	public static TryCount inputTryCount() {
		OutputView.printInputTryCount();

		try {
			String input = Console.readLine();
			return TryCount.from(input);
		} catch (IllegalArgumentException e) {
			OutputView.printErrorMessage(e.getMessage());
			return inputTryCount();
		}
	}
}
