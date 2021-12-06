package racingcar;

	import java.util.ArrayList;
	import java.util.List;

	import camp.nextstep.edu.missionutils.Console;

public class InputHandler {

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
