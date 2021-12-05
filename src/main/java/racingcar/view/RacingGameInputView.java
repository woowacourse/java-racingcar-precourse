package racingcar.view;

import static util.Constants.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class RacingGameInputView {
	private static final RacingGameInputView racingGameInputView = new RacingGameInputView();
	private final InputValidator inputValidator;

	private RacingGameInputView() {
		inputValidator = InputValidator.getInputValidator();
	}

	public static RacingGameInputView getRacingGameInputView() {
		return racingGameInputView;
	}

	public List<String> getCarNames() {
		List<String> carNamesList;
		do {
			System.out.println(CAR_NAME_INPUT_MESSAGE);
			carNamesList = new ArrayList<>(Arrays.asList(Console.readLine().split(",")));
		} while (!inputValidator.checkNameExceptions(carNamesList));
		return carNamesList;
	}

	public int getRepetitionNumber() {
		String repetitionNumber;
		do {
			System.out.println(REPETITION_NUMBER_MESSAGE);
			repetitionNumber = Console.readLine();
		} while (!inputValidator.checkRepetitionNumberExceptions(repetitionNumber));
		return Integer.parseInt(repetitionNumber);
	}
}
