package racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CarsTest {
	@Test
	void 자동차_이름은_쉼표로_구분() {
		Cars carsA = new Cars("carA,carB,carC");
		Cars carsB = new Cars(
			new Car("carA"),
			new Car("carB"),
			new Car("carC")
		);

		assertThat(carsA).isEqualTo(carsB);
	}

	@Test
	void 가장_먼_거리를_이동한_자동차가_우승() {
		Car carA = new Car("carA", 4);
		Car carB = new Car("carB", 3);
		Car carC = new Car("carC", 7);

		Cars cars = new Cars(carA, carB, carC);

		assertThat(cars.getWinner()).containsExactly(carC);
	}

	@Test
	void 공동_우승이_가능하다() {
		Car carA = new Car("carA", 4);
		Car carB = new Car("carB", 3);
		Car carC = new Car("carC", 4);

		Cars cars = new Cars(carA, carB, carC);

		assertThat(cars.getWinner()).containsExactly(carA, carC);
	}
}
