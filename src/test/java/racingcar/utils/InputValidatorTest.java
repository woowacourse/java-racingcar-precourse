package racingcar.utils;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InputValidatorTest {
	private static ArrayList<String> names;
	private InputValidator inputValidator = new InputValidator();

	@BeforeEach
	void initNames() {
		names = new ArrayList<>();
	}

	@Test
	void 이름이_오직_한개() {
		names.add("pobi");
		boolean isOnlyName = inputValidator.validateNames(names);
		assertEquals(isOnlyName, true);
	}

	@Test
	void 이름_길이가_초과한다() {
		names.add("pobi");
		names.add("veryLongName");
		boolean isLongName = inputValidator.validateNames(names);
		assertEquals(isLongName, true);
	}

	@Test
	void 중복된_이름이_있다() {
		names.add("pobi");
		names.add("pobi");
		boolean isDuplicateName = inputValidator.validateNames(names);
		assertEquals(isDuplicateName, true);
	}
}