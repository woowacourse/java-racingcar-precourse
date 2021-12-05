package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ValidationUtilsTest {
	@Test
	@DisplayName("0~9 숫자 테스트")
	void validNo_test() {
		assertThat(ValidationUtils.validNoRange(0)).isTrue();
		assertThat(ValidationUtils.validNoRange(9)).isTrue();
		assertThat(ValidationUtils.validNoRange(-1)).isFalse();
		assertThat(ValidationUtils.validNoRange(10)).isFalse();
	}

	@Test
	@DisplayName("숫자인지 체크")
	void validNumber_test() {
		assertThat(ValidationUtils.validNumber("a1")).isFalse();
		assertThat(ValidationUtils.validNumber("a")).isFalse();
	}

	@Test
	@DisplayName("사용자 입력 자동차 목록 테스트")
	void validCarList() {
		String[] testStr = {"abc", "def111", "ghi"};
		List<String> testList;
		testList = Arrays.asList(testStr);
		assertThat(ValidationUtils.validCarList(testList)).isFalse();
	}

	@Test
	@DisplayName("차 이름이 5글자가 넘지 않는지 테스트")
	void validCarNameTest() {
		String testCarName = "sojukang";
		assertThat(ValidationUtils.validCarName(testCarName)).isFalse();
	}
}
