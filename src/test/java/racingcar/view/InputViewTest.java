package racingcar.view;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.utils.CustomNsTest;

public class InputViewTest extends CustomNsTest {
	private static final String CORRECT_CAR_NAMES = "ozr,rag,wort";

	@DisplayName("차의 이름을 받아오는 기능 테스트")
	@Test
	public void readCarNamesTest() {
		command(CORRECT_CAR_NAMES);
		String[] testValues = CORRECT_CAR_NAMES.split(",");
		String[] inputs = InputView.readCarNames();
		for (int i = 0; i < testValues.length; i++) {
			assertEquals(inputs[i], testValues[i]);
		}
	}

	@Override
	protected void runMain() {
	}
}
