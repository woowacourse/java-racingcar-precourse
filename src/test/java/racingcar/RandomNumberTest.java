package racingcar;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("RandomNumber 클래스 유닛 테스트")
class RandomNumberTest {

	@Test
	@DisplayName("생성한 난수가 올바른 난수인지 체크")
	void getRandomNumber() {
		final RandomNumber randomNumber = new RandomNumber();

		assertTrue(0 <= randomNumber.getRandomNumber() && randomNumber.getRandomNumber() <= 9, "생성된 난수의 값이 0~9사이여야 한다");
	}
}
