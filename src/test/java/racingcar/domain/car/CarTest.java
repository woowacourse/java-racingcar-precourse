package racingcar.domain.car;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CarTest {

	@Test
	void 자동차의_이름은_1글자_이상_5글자_이하여야_한다() {
		for (String actual : new String[] { "", "너무긴이름이야" }) {
			assertThrows(CarNameLengthMustBetweenOneToFiveException.class, () -> new Car(actual));
		}
	}

	@ParameterizedTest
	@CsvSource("좋은이름,name,!@#$")
	void 자동차_생성_테스트(String actual) {
		assertDoesNotThrow(() -> new Car(actual));
	}

}