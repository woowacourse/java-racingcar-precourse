package racingcar.domain.car;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NameTest {

	@Test
	@DisplayName("문자열로 자동차를 생성할 수 있다.")
	public void testConstruction() {
		// given
		String input = "hello";
		// when
		assertDoesNotThrow(() -> new Name(input));
	}

	@Test
	@DisplayName("이름에 UTF-8 값(이모지)도 입력할 수 있다.")
	public void testConstructionWithEmoji() {
		// given
		String input = "😀";
		// then
		assertDoesNotThrow(() -> new Name(input));
	}

	@Test
	@DisplayName("이름이 6자를 초과해서는 안된다.")
	public void testConstructionTooLong() {
		// given
		String input = "someLongName";
		// then
		assertThrows(IllegalArgumentException.class, () -> new Name(input));
	}

	@Test
	@DisplayName("이름이 빈 문자열이어서는 안된다.")
	public void testConstructionWithEmpty() {
		// given
		String input = "";
		// then
		assertThrows(IllegalArgumentException.class, () -> new Name(input));
	}
}