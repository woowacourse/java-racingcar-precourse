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

	private String[] parseRacingCarNames(String carNames) {
		return carNames.split(",");
	}
}
