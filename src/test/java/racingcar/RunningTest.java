package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;

import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class RunningTest extends NsTest {
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
	void 게임끝까지실행() {
		assertRandomNumberInRangeTest(
			() -> {
				run("pobi,woni", "2");
				assertThat(output()).contains("pobi : --", "woni : ", "최종 우승자 : pobi");
			},
			MOVING_FORWARD, STOP,
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

	@Test
	void 이름에_대한_예외_처리2() {
		assertSimpleTest(
			() -> {
				runException("pobi,");
				assertThat(output()).contains(ERROR_MESSAGE);
			}
		);
	}

	@Test
	void 이름에_대한_예외_처리3() {
		assertSimpleTest(
			() -> {
				runException("-");
				assertThat(output()).contains(ERROR_MESSAGE);
			}
		);
	}

	@Test
	void 이름에_대한_예외_처리4() {
		assertSimpleTest(
			() -> {
				runException("pobi,pobi");
				assertThat(output()).contains(ERROR_MESSAGE);
			}
		);
	}

	@Test
	void 이름에_대한_예외_처리6() {
		assertSimpleTest(
			() -> {
				runException("/n");
				assertThat(output()).contains(ERROR_MESSAGE);
			}
		);
	}

	@Test
	void 이름에_대한_예외_처리7() {
		assertSimpleTest(
			() -> {
				runException("a,b,c,,d");
				assertThat(output()).contains(ERROR_MESSAGE);
			}
		);
	}

	@Test
	void 이름에_대한_예외_처리8() {
		assertSimpleTest(
			() -> {
				runException(",a,b");
				assertThat(output()).contains(ERROR_MESSAGE);
			}
		);
	}

	@Test
	void 숫자에_대한_예외_처리() {
		assertSimpleTest(
			() -> {
				runException("a,b", "0");
				assertThat(output()).contains(ERROR_MESSAGE);
			}
		);
	}

	@Test
	void 숫자에_대한_예외_처리2() {
		assertSimpleTest(
			() -> {
				runException("a,b", "01");
				assertThat(output()).contains(ERROR_MESSAGE);
			}
		);
	}

	@Test
	void 숫자에_대한_예외_처리3() {
		assertSimpleTest(
			() -> {
				runException("a,b", "11");
				assertThat(output()).doesNotContain(ERROR_MESSAGE);
			}
		);
	}

	@Override
	public void runMain() {
		Application.main(new String[] {});
	}
}

