package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import camp.nextstep.edu.missionutils.test.NsTest;

class ApplicationCustomTest extends NsTest {

	@Test
	void 이름_공백에_대한_예외_처리 () {
		assertSimpleTest(() -> {
			runException("asdf ,qwert");
			assertThat(output()).contains(GameData.CARNAME_EMPTY_ERROR_MESSAGE);
		});
	}

	@Test
	void 이름_중복에_대한_예외_처리 () {
		assertSimpleTest(() -> {
			runException("asdf,qwert,asdf");
			assertThat(output()).contains(GameData.CARNAME_DUPLICATED_ERROR_MESSAGE);
		});
	}

	@Test
	void 수행횟수_음수에_대한_예외 () {
		assertSimpleTest(() -> {
			runException("asdf,qwert", "-1");
			assertThat(output()).contains(GameData.TURNCOUNT_TOO_SMALL_ERROR_MESSAGE);
		});
	}

	@Test
	void 수행횟수_정수가_아닌것에_대한_예외 () {
		assertSimpleTest(() -> {
			runException("asdf,qwert", "z");
			assertThat(output()).contains(GameData.TURNCOUNT_NOT_INTEGER_ERROR_MESSAGE);
		});
	}

	@Override
	public void runMain() {
		Application.main(new String[] {});
	}
}
