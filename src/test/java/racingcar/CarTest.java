package racingcar;

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
		move.moveOrStop(4);
		assertTrue(move.isMoved());

		Car noMove = new Car("noMov");
		noMove.moveOrStop(3);
		assertFalse(noMove.isMoved());
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

	@ParameterizedTest
	@NullAndEmptySource
	void checkEmpty(String carName) {
		assertThatThrownBy(() -> new Car(carName))
			.isInstanceOf(IllegalArgumentException.class);
	}
}
