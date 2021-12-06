package racingcar.util;

import static camp.nextstep.edu.missionutils.test.Assertions.*;
import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.Test;

public class ValidatorTest {
	private final Validator validator = new Validator();
	private static final String ERROR_MESSAGE = "[ERROR]";

	@Test
	void 자동차이름_빈문자_입력() {
		assertSimpleTest(() -> assertThatThrownBy(() -> validator.checkCarNamesInput(""))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining(ERROR_MESSAGE));
	}

	@Test
	void 시도횟수이름_빈문자_입력() {
		assertSimpleTest(() -> assertThatThrownBy(() -> validator.checkNumberOfTrialInput(""))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining(ERROR_MESSAGE));
	}

	@Test
	void 자동차이름_1글자미만() {
		assertSimpleTest(() -> assertThatThrownBy(() -> validator.checkCarNamesInput("a,"))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining(ERROR_MESSAGE));
		assertSimpleTest(() -> assertThatThrownBy(() -> validator.checkCarNamesInput("a,b,,c"))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining(ERROR_MESSAGE));
	}

	@Test
	void 자동차이름_5글자초과() {
		assertSimpleTest(() -> assertThatThrownBy(() -> validator.checkCarNamesInput("a,b,avsdfe"))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining(ERROR_MESSAGE));
	}

	@Test
	void 자동차이름_공백() {
		assertSimpleTest(() -> assertThatThrownBy(() -> validator.checkCarNamesInput("a, ,c"))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining(ERROR_MESSAGE));
	}

	@Test
	void 자동차이름_중복() {
		assertSimpleTest(() -> assertThatThrownBy(() -> validator.checkCarNamesInput("a,a"))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining(ERROR_MESSAGE));
	}

	@Test
	void 시도횟수_문자() {
		assertSimpleTest(() -> assertThatThrownBy(() -> validator.checkNumberOfTrialInput("a"))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining(ERROR_MESSAGE));
	}
}
