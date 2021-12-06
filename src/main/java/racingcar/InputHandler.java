package racingcar;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class InputHandler {

	OutputHandler outputHandler;

	public InputHandler() {
		outputHandler = new OutputHandler();
	}

	public List<String> getValidCarNames() {
		outputHandler.printMessage(GameData.CARNAME_INPUT_MESSAGE);
		while (true) {
			try {
				return readRacingCarNames();
			} catch (IllegalArgumentException iae) {
				outputHandler.printErrorMessage(iae);
			}
		}
	}

	public int getValidTurnCount() {
		outputHandler.printMessage(GameData.TRY_INPUT_MESSAGE);
		while (true) {
			try {
				return readCount();
			} catch (IllegalArgumentException iae) {
				outputHandler.printErrorMessage(iae);
			}
		}
	}

	public List<String> readRacingCarNames() {
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

	public int readCount() {
		String input = Console.readLine();
		InputValidator.validateTurnCountIsInteger(input);
		int turnCount = Integer.parseInt(input);
		InputValidator.validateTurnCountNotTooSmall(turnCount);
		return turnCount;
	}

	private String[] parseRacingCarNames(String carNames) {
		return carNames.split(",");
	}
}
