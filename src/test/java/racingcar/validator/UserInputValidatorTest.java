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

	@ParameterizedTest(name = "유저_이동횟수_입력_[{arguments}]_정수_오류")
	@ValueSource(strings = {"1.1", "1a", "", "자1동차다"})
	void 유저_이동횟수_입력_정수_오류(String userInputIterationNumber) {
		// given, when, then
		Assertions.assertThatThrownBy(
				() -> UserInputValidator.validateUserInputIterationNumberInteger(userInputIterationNumber))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@ParameterizedTest(name = "유저_이동횟수_입력_[{arguments}]_정수_오류")
	@ValueSource(strings = {"-1", "1", "987564321"})
	void 유저_이동횟수_입력_정수_정상(String userInputIterationNumber) {
		// given, when, then
		Assertions.assertThatNoException().isThrownBy(
			() -> UserInputValidator.validateUserInputIterationNumberInteger(userInputIterationNumber));
	}

	@ParameterizedTest(name = "유저_이동횟수_입력_[{arguments}]_범위_오류")
	@ValueSource(strings = {"-1", "0"})
	void 유저_이동횟수_입력_범위_오류(String userInputIterationNumber) {
		// given, when, then
		Assertions.assertThatThrownBy(
				() -> UserInputValidator.validateUserInputIterationNumberRange(userInputIterationNumber))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@ParameterizedTest(name = "유저_이동횟수_입력_[{arguments}]_범위_정상")
	@ValueSource(strings = {"1", "987654321"})
	void 유저_이동횟수_입력_범위_정상(String userInputIterationNumber) {
		// given, when, then
		Assertions.assertThatNoException().isThrownBy(
			() -> UserInputValidator.validateUserInputIterationNumberRange(userInputIterationNumber));
	}
}
