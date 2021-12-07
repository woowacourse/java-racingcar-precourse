package racingcar.io;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import racingcar.data.GameData;
import racingcar.io.validator.InputValidator;

public class InputHandler {

	OutputHandler outputHandler;

	public InputHandler(OutputHandler outputHandler) {
		this.outputHandler = outputHandler;
	}

	public List<String> getValidCarNames() {
		outputHandler.printMessage(GameData.CARNAME_INPUT_MESSAGE);
		while (true) {
			try {
				return readCarNames();
			} catch (IllegalArgumentException iae) {
				outputHandler.printErrorMessage(iae);
			}
		}
	}

	public int getValidTurnCount() {
		outputHandler.printMessage(GameData.TRY_INPUT_MESSAGE);
		while (true) {
			try {
				return readTurnCount();
			} catch (IllegalArgumentException iae) {
				outputHandler.printErrorMessage(iae);
			}
		}
	}

	private List<String> readCarNames() {
		String[] racingCarNames = parseRacingCarNames(Console.readLine());
		List<String> results = new ArrayList<String>();
		for (String racingCarName : racingCarNames) {
			results.add(racingCarName);
		}
		InputValidator.validateNameLength(results);
		InputValidator.validateNameIsDuplicated(results);
		InputValidator.validateNameContatainsEmptyString(results);
		return results;
	}

	private int readTurnCount() {
		String input = Console.readLine();
		InputValidator.validateTurnCountIsInteger(input);
		int turnCount = Integer.parseInt(input);
		InputValidator.validateTurnCountNotTooSmall(turnCount);
		return turnCount;
	}

	private String[] parseRacingCarNames(String carNames) {
		return carNames.split(GameData.CARNAME_SEPARATOR);
	}
}
