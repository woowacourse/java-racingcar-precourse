package racingcar.view;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import racingcar.domain.Car;

class InputViewTest {

	InputStrategy inputStrategy;

	@Test
	void 자동차이름_입력받기_정상() {
		inputStrategy = new FixedInputStrategy("ab,cd,def", "5");
		InputView.input(inputStrategy);
	}

	@Test
	void 자동차이름_입력받기_예외_이름_2개() {
		inputStrategy = new FixedInputStrategy("ab,cd", "5");
		assertThatThrownBy(() -> InputView.input(inputStrategy))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage(InputStrategy.ERROR_INPUT_CAR_NAMES);
	}

	@Test
	void 자동차이름_입력받기_예외_이름_4개() {
		inputStrategy = new FixedInputStrategy("ab,cd,de,ef", "5");
		assertThatThrownBy(() -> InputView.input(inputStrategy))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage(InputStrategy.ERROR_INPUT_CAR_NAMES);
	}

	@Test
	void 자동차이름_입력받기_예외_이름_5글자_초과() {
		// 어느 한 입력이 5글자를 초과한 경우
		inputStrategy = new FixedInputStrategy("ab,cd,abcdef", "5");
		assertThatThrownBy(() -> InputView.input(inputStrategy))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage(Car.ERROR_OUT_OF_NAME_LENGTH);
	}

	@Test
	void 시행횟수가_예외_숫자가_아님() {
		inputStrategy = new FixedInputStrategy("ab,cd,ef", "a");
		assertThatThrownBy(() -> InputView.input(inputStrategy))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage(InputStrategy.ERROR_INPUT_TRY_NUMBER);
	}
}