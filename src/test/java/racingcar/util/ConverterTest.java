package racingcar.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ConverterTest {
	@Test
	public void convertToStringArray() throws Exception {
		// given
		String given = "a,테스트,pobi,가나다라마바사";
		// when
		String[] result = Converter.toStringArray(given);
		// then
		assertEquals(result[0], "a");
		assertEquals(result[1], "테스트");
		assertEquals(result[2], "pobi");
		assertEquals(result[3], "가나다라마바사");
	}

	@Test
	public void convertToInt() throws Exception {
		// given
		String given = "140";
		// when
		int result = Converter.toInt(given);
		// then
		assertEquals(140, result);
	}

	@DisplayName("시도 횟수는 숫자여야 한다.")
	@Test
	public void convertToIntNotNumber() throws Exception {
		// given
		String given = "가나다라마바사";
		// when
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
			() -> Converter.toInt(given));
		// then
		assertEquals(e.getMessage(), "[ERROR] 시도 횟수는 숫자여야 한다.");
	}
}
