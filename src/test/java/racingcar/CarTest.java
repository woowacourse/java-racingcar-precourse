package racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CarTest {
	Car car;

	@BeforeEach
	void setUp() {
		car = new Car("car");
	}

	@Test
	void 자동차_이름은_5자를_초과하면_안된다() {
		assertThatThrownBy(() -> new Car("exception"))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@ParameterizedTest
	@CsvSource(value = {"4:1", "3:0"}, delimiter = ':')
	void 자동차는_4이상이면_전진_4미만이면_정지(String inputStr, String expectedStr) {
		int input = Integer.parseInt(inputStr);
		int expected = Integer.parseInt(expectedStr);

		car.controlByNumber(input);

		assertThat(car.getPosition()).isEqualTo(expected);
	}

}
