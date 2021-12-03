package racingcar.utils;

import static org.junit.jupiter.api.Assertions.*;
import static racingcar.utils.MoveCountValidator.*;

import org.junit.jupiter.api.Test;

class MoveCountValidatorTest {
	private MoveCountValidator moveCountValidator = new MoveCountValidator();

	@Test
	void 이동횟수가_정수가_아닌_값_일때() {
		String move = "word";
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
			() -> moveCountValidator.validateMove(move));
		assertEquals(exception.getMessage(), ERROR_NOT_INTEGER);
	}

	@Test
	void 이동횟수가_0_일_경우() {
		String move = "0";
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
			() -> moveCountValidator.validateMove(move));
		assertEquals(exception.getMessage(), ERROR_ZERO_OR_NEGATIVE);
	}

	@Test
	void 이동횟수가_음수_일_경우() {
		String move = "-23";
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
			() -> moveCountValidator.validateMove(move));
		assertEquals(exception.getMessage(), ERROR_ZERO_OR_NEGATIVE);
	}

}