package racingcar;

import static util.Constants.*;

import java.util.ArrayList;
import java.util.Arrays;

import camp.nextstep.edu.missionutils.Console;

public class RacingGameView {

	public ArrayList<String> getCarNames() {
		ArrayList<String> carNamesList;
		do {
			System.out.println(CAR_NAME_INPUT_MESSAGE);
			carNamesList = new ArrayList<>(Arrays.asList(Console.readLine().split(",")));
		} while (checkLongNameException(carNamesList));
		return carNamesList;
	}

	private boolean checkLongNameException(ArrayList<String> carNamesList) {
		try {
			if (carNamesList.stream().anyMatch(carName -> carName.length() > MAXIMUM_NAME_LENGTH)) {
				System.out.println(CAR_NAME_INPUT_ERROR_MESSAGE);
				throw new IllegalArgumentException();
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}
}
