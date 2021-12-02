package racingcar.util;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class ParserTest {

	private Parser parser = new Parser();
	private static final String ERROR_MESSAGE = "[ERROR]";

	@Test
	void 자동차이름_정상입력_파싱() {
		String input1 = "aaa,bbb,ccc,ddd";
		List<String> result1 = parser.parseCarNames(input1);
		assertThat(result1).contains("aaa", "bbb", "ccc", "ddd");
	}

	@Test()
	void 자동차이름_다섯글자초과_예외처리() {
		String input1 = "aaa,bbb,ccc,ddddddd";
		assertThatThrownBy(() -> parser.parseCarNames(input1))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining(ERROR_MESSAGE);
	}

	@Test()
	void 자동차이름_한글자미만_예외처리() {
		String input1 = "aaa,,ccc,ddddd";
		assertThatThrownBy(() -> parser.parseCarNames(input1))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining(ERROR_MESSAGE);
	}

	@Test()
	void 자동차이름_빈문자_예외처리() {
		String input1 = "";
		assertThatThrownBy(() -> parser.parseCarNames(input1))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining(ERROR_MESSAGE);
	}
}