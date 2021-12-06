package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

	@Test
	@DisplayName("자동차의 이름은 5자를 초과할 수 없다.")
	public void nameLengthExceed() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Car("abcdef"));
	}

	@Test
	@DisplayName("자동차의 이름은 비어있거나 null일 수 없다.")
	public void nameIsEmpty() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Car(""));
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Car(null));
	}
}
