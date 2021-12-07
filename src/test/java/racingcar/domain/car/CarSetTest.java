package racingcar.domain.car;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.domain.movement.InputMovementStrategy;

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

	@Test
	@DisplayName("자동차의 위치를 기반으로 비교할 수 있다.")
	public void testCarPositionComparable() throws Exception {
		// given
		Car carA = new Car("A");
		Car carB = new Car("B");
		Car carC = new Car("C");
		carA.move(new InputMovementStrategy(1));
		carB.move(new InputMovementStrategy(2));
		carC.move(new InputMovementStrategy(3));
		List<Car> cars = new ArrayList<>(Arrays.asList(carA, carB, carC));
		// when
		CarSet carSet = new CarSet(cars);
		// then
		List<Car> winners = carSet.getWinners();
		assertEquals(1, winners.size());
		assertSame(winners.get(0), carC);
	}

}
