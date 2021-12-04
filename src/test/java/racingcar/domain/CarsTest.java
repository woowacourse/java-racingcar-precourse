package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarsTest {
	Cars cars;
	OutputStream out;

	@BeforeEach
	void beforeEach() {
		String[] names = {"Kim", "Park"};
		cars = new Cars(names);
		out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
	}

	@Test
	void 우승자_1명() throws Exception {
		Field carsFiled = Cars.class.getDeclaredField("cars");
		carsFiled.setAccessible(true);
		List<Car> cars = (List<Car>)carsFiled.get(this.cars);
		Field positionField = Car.class.getDeclaredField("position");
		positionField.setAccessible(true);

		// given
		Car car1 = cars.get(0);
		Car car2 = cars.get(1);
		positionField.set(car1, 3);
		positionField.set(car2, 2);

		// when
		this.cars.getWinner();

		// then
		assertThat(out.toString().trim()).isEqualTo("최종 우승자 : " + car1.getName());
	}

	@Test
	void 공동우승() throws Exception {
		Field carsField = Cars.class.getDeclaredField("cars");
		carsField.setAccessible(true);
		List<Car> cars = (List<Car>)carsField.get(this.cars);
		Field positionField = Car.class.getDeclaredField("position");
		positionField.setAccessible(true);

		// given
		Car car1 = cars.get(0);
		Car car2 = cars.get(1);
		positionField.set(car1, 2);
		positionField.set(car2, 2);

		// when
		this.cars.getWinner();

		// then
		assertThat(out.toString().trim()).isEqualTo("최종 우승자 : " + car1.getName() + ", " + car2.getName());
	}
}