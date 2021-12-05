package racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputViewTest {
	@ParameterizedTest
	@ValueSource(strings = {"exception", "3.5"})
	void 시도할_횟수_숫자가_아닌_경우_TRUE_반환(String input) {
		InputView inputView = new InputView();
		assertThat(inputView.isTimesNotInteger(input)).isTrue();
	}
}
