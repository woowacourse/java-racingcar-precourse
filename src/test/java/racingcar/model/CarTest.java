package racingcar.model;

import static org.assertj.core.api.AssertionsForClassTypes.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

public class CarTest {

	@DisplayName("자동차가 잘 움직이는지 테스트")
	@Test
	void move() {
		Car move = new Car("move");
		move.moveOrStop(new CarPower(4));
		assertEquals(new Car("move", 1), move);

		Car noMove = new Car("noMov");
		noMove.moveOrStop(new CarPower(3));
		assertEquals(new Car("noMov", 0), noMove);
	}

	@DisplayName("자동차의 이름이 5자가 넘지 않는지 테스트")
	@Test
	void checkLength() {
		assertAll(
			() -> assertThatThrownBy(() -> new Car("123456"))
				.isInstanceOf(IllegalArgumentException.class),
			() -> assertDoesNotThrow(() -> new Car("12345"))
		);
	}

	@DisplayName("null이나 empty string이 입력되었을 시 에러 테스트")
	@ParameterizedTest
	@NullAndEmptySource
	void checkEmpty(String carName) {
		assertThatThrownBy(() -> new Car(carName))
			.isInstanceOf(IllegalArgumentException.class);
	}
}
