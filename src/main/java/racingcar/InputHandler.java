package racingcar;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class InputHandler {

	public List<String> readRacingCarNames() {
		String[] racingCarNames = parseRacingCarNames(Console.readLine());
		List<String> results = new ArrayList<String>();
		for (String racingCarName : racingCarNames) {
			if (racingCarName.length() > 5) {
				throw new IllegalArgumentException(racingCarName);
			}
			results.add(racingCarName);
		}
		return results;
	}

	public int readCount() {
		String input = Console.readLine();
		try {
			return parseCount(input);
		} catch (NumberFormatException nfe) {
			throw new IllegalArgumentException(input, nfe);
		}
	}

	private int parseCount(String count) {
		return Integer.parseInt(count);
	}

	private String[] parseRacingCarNames(String carNames) {
		return carNames.split(",");
	}
}
