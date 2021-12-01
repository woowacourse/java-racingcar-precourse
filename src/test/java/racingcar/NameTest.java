package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NameTest {
	@Test
	@DisplayName("차 이름이 5글자가 넘지 않는지 테스트")
	void validCarNameTest() {
		String testCarName = "sojukang";
		assertThat(ValidationUtils.validCarName(testCarName)).isFalse();
	}
}
