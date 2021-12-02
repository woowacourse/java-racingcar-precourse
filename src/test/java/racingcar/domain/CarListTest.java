package racingcar.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarListTest {
	CarList carList;
	OutputStream out;

	@BeforeEach
	void beforeEach() {
		String[] names = {"Kim", "Park"};
		carList = new CarList(names);
		out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
	}

	@Test
	void 우승자_1명() throws Exception {
		Field listField = CarList.class.getDeclaredField("list");
		listField.setAccessible(true);
		List<Car> list = (List<Car>)listField.get(carList);
		Field positionField = Car.class.getDeclaredField("position");
		positionField.setAccessible(true);

		// given
		Car car1 = list.get(0);
		Car car2 = list.get(1);
		positionField.set(car1, 3);
		positionField.set(car2, 2);

		// when
		carList.getWinner();

		// then
		assertThat(out.toString().trim()).isEqualTo("최종 우승자 : " + car1.getName());
	}

	@Test
	void 공동우승() throws Exception {
		Field listField = CarList.class.getDeclaredField("list");
		listField.setAccessible(true);
		List<Car> list = (List<Car>)listField.get(carList);
		Field positionField = Car.class.getDeclaredField("position");
		positionField.setAccessible(true);

		// given
		Car car1 = list.get(0);
		Car car2 = list.get(1);
		positionField.set(car1, 2);
		positionField.set(car2, 2);

		// when
		carList.getWinner();

		// then
		assertThat(out.toString().trim()).isEqualTo("최종 우승자 : " + car1.getName() + ", " + car2.getName());
	}
}