package racingcar;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {
	@Test
	@DisplayName("자동차들의 이름은 중복될 수 없다.")
	public void duplicateName() {
		String[] names = {"test1", "test2", "test3", "test1"};
		assertThrows(IllegalArgumentException.class, () -> Cars.of(names));
	}

}
