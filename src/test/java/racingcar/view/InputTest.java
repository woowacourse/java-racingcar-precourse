package racingcar.view;

import static camp.nextstep.edu.missionutils.test.Assertions.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import camp.nextstep.edu.missionutils.test.NsTest;
import racingcar.Application;

class InputTest extends NsTest {

	private static final String ERROR_MESSAGE = "[ERROR]";

	@Override
	protected void runMain() {
		Application.main(new String[]{});
	}

	@Test
	void 이름이_5자_이상일때_예외_처리() {
		assertSimpleTest(
			() -> {
				runException("juri,jurizzang");
				assertThat(output()).contains(ERROR_MESSAGE);
			}
		);
	}

	@Test
	void 빈_문자열이_입력된_경우_예외_처리() {
		assertSimpleTest(
			() -> {
				runException("\n");
				assertThat(output()).contains(ERROR_MESSAGE);
			}
		);
	}

	@Test
	void 공백인_이름이_입력된_경우_예외_처리() {
		assertSimpleTest(
			() -> {
				runException("juri,  ");
				assertThat(output()).contains(ERROR_MESSAGE);
			}
		);
	}

	@Test
	void 중복된_이름에_대한_예외_처리() {
		assertSimpleTest(
			() -> {
				runException("ggu,juri,juri");
				assertThat(output()).contains(ERROR_MESSAGE);
			}
		);
	}

	@Test
	void 입력된_이름이_하나일_경우_예외_처리() {
		assertSimpleTest(
			() -> {
				runException("juri");
				assertThat(output()).contains(ERROR_MESSAGE);
			}
		);
	}

}