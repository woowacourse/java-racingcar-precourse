package racingcar;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.model.Car;
import racingcar.model.RacingCars;

public class MyTest {
	@Test
	@DisplayName("Car 속 객체 확인")
	void Test1() {
		Car car = new Car("jiwoo");
		assertThat(car.getName())
			.isEqualTo("jiwoo");

		assertThat(car.getPosition())
			.isEqualTo(0);

		car.go();

		assertThat(car.getPosition())
			.isEqualTo(0);
	}

	@Test
	@DisplayName("최댓값 나오는지 확인")
	void Test2() {
		ArrayList<Integer> positions = new ArrayList<>();

		for (int i = 1; i < 6; i++) {
			positions.add(i);
		}
		System.out.println(positions);

		assertThat(RacingCars.findMax(positions))
			.isEqualTo(5);
	}
}
