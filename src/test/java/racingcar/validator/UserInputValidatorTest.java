package racingcar.validator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class UserInputValidatorTest {

	@ParameterizedTest(name = "유저_이름_입력_[{0}]_오류")
	@ValueSource(strings = {"", "나는자1동차"})
	void 유저_이름_입력_오류(String userInputName) {
		// given, when, then
		Assertions.assertThatThrownBy(() -> UserInputValidator.validateUserInputNameLength(userInputName))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@ParameterizedTest(name = "유저_이름_입력_[{0}]_정상")
	@ValueSource(strings = {"1", "자1동차다"})
	void 유저_이름_입력_정상(String userInputName) {
		// given, when, then
		Assertions.assertThatNoException()
			.isThrownBy(() -> UserInputValidator.validateUserInputNameLength(userInputName));
	}
}
