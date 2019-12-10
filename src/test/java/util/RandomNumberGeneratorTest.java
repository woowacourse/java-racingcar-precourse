package util;

import static org.assertj.core.api.AssertionsForInterfaceTypes.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("랜덤 숫자 생성기 테스트")
class RandomNumberGeneratorTest {

	@Test
	@DisplayName("0부터 9사이의 숫자인지 확인 ")
	void test() {
		for (int i = 0; i < 5; i++) {
			int randomNumber = RandomNumberGenerator.generateNumber();
			assertThat(randomNumber).isBetween(0, 9);
		}
	}
}