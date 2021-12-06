package racingcar.view;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.utils.CustomNsTest;

public class InputViewTest extends CustomNsTest {
	private static final String CORRECT_CAR_NAMES = "ozr,rag,wort";
	private static final String INVALID_DUPLICATE_CAR_NAMES = "ozr,rag,ozr";
	private static final String INVALID_LONG_LENGTH_CAR_NAMES = "ozr,ragwort";
	private static final String INVALID_EMPTY_LENGTH_CAR_NAMES = "ozr,,wort";

	private static final String CORRECT_RACING_ROUND = "3";
	private static final String INVALID_FORMAT_ROUND = "ragwort";
	private static final String INVALID_ZERO_ROUND = "0";
	private static final String INVALID_NEGATIVE_ROUND = "-1";

	private static final String ERROR_MESSAGE = "[ERROR]";

	@DisplayName("차의 이름을 받아오는 테스트")
	@Test
	public void readCarNamesTest() {
		command(CORRECT_CAR_NAMES);
		String[] testValues = CORRECT_CAR_NAMES.split(",");
		String[] inputs = InputView.readCarNames();
		for (int i = 0; i < testValues.length; i++) {
			assertEquals(inputs[i], testValues[i]);
		}
	}

	@DisplayName("잘못된 자동차 이름 입력 시 예외 처리 후 재입력 테스트")
	@Test
	public void readCarNamesReloadTest() {
		command(INVALID_LONG_LENGTH_CAR_NAMES, CORRECT_CAR_NAMES);
		String[] testValues = CORRECT_CAR_NAMES.split(",");
		String[] inputs = InputView.readCarNames();
		assertThat(output()).contains(ERROR_MESSAGE);
		for (int i = 0; i < testValues.length; i++) {
			assertEquals(inputs[i], testValues[i]);
		}
	}

	@DisplayName("자동차 이름 중복 입력 예외 테스트")
	@Test
	public void readCarNamesDuplicateExceptionTest() {
		command(INVALID_DUPLICATE_CAR_NAMES);
		try {
			InputView.readCarNames();
		} catch (NoSuchElementException ignored) {
		}
		assertThat(output()).contains(ERROR_MESSAGE);
	}

	@DisplayName("자동차 이름 길이 초과 예외 테스트")
	@Test
	public void readCarNamesLongLengthExceptionTest() {
		command(INVALID_LONG_LENGTH_CAR_NAMES);
		try {
			InputView.readCarNames();
		} catch (NoSuchElementException ignored) {
		}
		assertThat(output()).contains(ERROR_MESSAGE);
	}

	@DisplayName("자동차 이름 빈칸 입력 예외 테스트")
	@Test
	public void readCarNamesExceptionTest() {
		command(INVALID_EMPTY_LENGTH_CAR_NAMES);
		try {
			InputView.readCarNames();
		} catch (NoSuchElementException ignored) {
		}
		assertThat(output()).contains(ERROR_MESSAGE);
	}

	@DisplayName("잘못된 시도 횟수 입력시 예외 처리 후 재입력 테스트")
	@Test
	public void readRacingRoundReloadTest() {
		command(INVALID_FORMAT_ROUND, CORRECT_RACING_ROUND);
		try {
			int input = InputView.readRacingRound();
			assertThat(output()).contains(ERROR_MESSAGE);
			assertEquals(input, Integer.parseInt(CORRECT_RACING_ROUND));
		} catch (NoSuchElementException ignored) {
		}
	}

	@DisplayName("시도 횟수 입력 테스트")
	@Test
	public void readRacingRoundTest() {
		command(CORRECT_RACING_ROUND);
		try {
			int input = InputView.readRacingRound();
			assertEquals(input, Integer.parseInt(CORRECT_RACING_ROUND));
		} catch (NoSuchElementException ignored) {
		}
	}

	@DisplayName("시도 횟수 형식 예외 테스트")
	@Test
	public void readRacingRoundFormatExceptionTest() {
		command(INVALID_FORMAT_ROUND);
		try {
			InputView.readRacingRound();
			assertThat(output()).contains(ERROR_MESSAGE);
		} catch (NoSuchElementException ignored) {
		}
	}

	@DisplayName("시도 횟수 0입력 예외 테스트")
	@Test
	public void readRacingRoundZeroExceptionTest() {
		command(INVALID_ZERO_ROUND);
		try {
			InputView.readRacingRound();
			assertThat(output()).contains(ERROR_MESSAGE);
		} catch (NoSuchElementException ignored) {
		}
	}

	@DisplayName("시도 횟수 음수 입력 예외 테스트")
	@Test
	public void readRacingRoundNegativeNumberExceptionTest() {
		command(INVALID_NEGATIVE_ROUND);
		try {
			InputView.readRacingRound();
			assertThat(output()).contains(ERROR_MESSAGE);
		} catch (NoSuchElementException ignored) {
		}
	}

	@Override
	protected void runMain() {
	}
}
