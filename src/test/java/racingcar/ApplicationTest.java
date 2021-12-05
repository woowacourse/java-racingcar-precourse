package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import camp.nextstep.edu.missionutils.test.NsTest;

class ApplicationTest extends NsTest {
	private static final int MOVING_FORWARD = 4;
	private static final int STOP = 3;

	private static final String ERROR_MESSAGE = "[ERROR]";

	@Test
	void 전진_정지() {
		assertRandomNumberInRangeTest(
			() -> {
				run("pobi,woni", "1");
				assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
			},
			MOVING_FORWARD, STOP
		);
	}

	@Test
	void 이름에_대한_예외_처리() {
		assertSimpleTest(
			() -> {
				runException("pobi,javaji");
				assertThat(output()).contains(ERROR_MESSAGE);
			}
		);
	}

	@Override
	public void runMain() {
		Application.main(new String[] {});
	}
}
