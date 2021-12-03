package racingcar;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CarRacingGameTest {
	private CarRacingGame game = new CarRacingGame();

	@Test
	void isNameInputException() {
		String[] namesTrue = {"ab", "abc", "abcde"};
		assert game.isNamesInputException(namesTrue) == false;

		String[] namesLengthFalse = {"ab", "abc", "abcdef"};
		assert game.isNamesInputException(namesLengthFalse) == true;

		String[] namesDistinctFalse = {"ab", "abc", "abc"};
		assert game.isNamesInputException(namesDistinctFalse) == true;
	}

}