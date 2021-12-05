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
}
