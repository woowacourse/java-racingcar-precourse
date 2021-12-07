package racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputViewTest {
	@ParameterizedTest
	@ValueSource(strings = {"exception", "3.5"})
	void 시도횟수에_문자를_입력하면_안된다(String input) {
		InputView inputView = new InputView();
		assertThat(inputView.isTimesNotInteger(input)).isTrue();
	}
}
