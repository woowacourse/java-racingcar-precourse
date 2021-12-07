package racingcar.domain.car;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarSetTest {

	@Test
	@DisplayName("이름은 중복되어서는 안된다.")
	public void testConstructionWithDuplication() {
		// given
		String duplicatedName = "pobi";
		Car carA = new Car(duplicatedName);
		Car carB = new Car(duplicatedName);
		// when
		List<Car> cars = Arrays.asList(carA, carB);
		// then
		assertThrows(IllegalArgumentException.class, () -> new CarSet(cars));
	}

	@Test
	@DisplayName("자동차 리스트가 비어서는 안된다.")
	public void testConstructionWithNone() {
		// given
		List<Car> cars = new ArrayList<>();
		// then
		assertThrows(IllegalArgumentException.class, () -> new CarSet(cars));
	}
}
