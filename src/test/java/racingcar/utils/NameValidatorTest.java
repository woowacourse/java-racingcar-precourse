package racingcar.utils;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NameValidatorTest {
	private static ArrayList<String> names;
	private NameValidator inputValidator = new NameValidator();

	@BeforeEach
	void initNames() {
		names = new ArrayList<>();
	}

	@Test
	void 이름이_오직_한개() {
		names.add("pobi");
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
			() -> inputValidator.validateNames(names));
		assertEquals(exception.getMessage(), NameValidator.ERROR_ONLY_NAME);
	}

	@Test
	void 이름_길이가_초과한다() {
		names.add("pobi");
		names.add("veryLongName");
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
			() -> inputValidator.validateNames(names));
		assertEquals(exception.getMessage(), NameValidator.ERROR_LONG_NAME);
	}

	@Test
	void 중복된_이름이_있다() {
		names.add("pobi");
		names.add("pobi");
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
			() -> inputValidator.validateNames(names));
		assertEquals(exception.getMessage(), NameValidator.ERROR_DUPLICATE_NAME);
	}

	@Test
	void 공백_이름이_있는_경우() {
		names.add(" ");
		names.add("  ");
		names.add("pobi");
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
			() -> inputValidator.validateNames(names));
		assertEquals(exception.getMessage(), NameValidator.ERROR_EMPTY_NAME);
	}

	@Test
	void 이름이_없을_경우() {
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
			() -> inputValidator.validateNames(names));
		assertEquals(exception.getMessage(), NameValidator.ERROR_EMPTY_NAME);
	}
}