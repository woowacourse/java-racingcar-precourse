package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Collections;

import org.junit.jupiter.api.Test;

class CarTest {
	@Test
	void 출력_확인() {
		// given
		Car car = new Car("name");
		OutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		int randomNumber = 4;

		// when
		car.playOnce(randomNumber);

		// then
		String result = out.toString();

		assertThat(result).contains(car.getName());
		assertThat(Collections.frequency(Arrays.asList(result.split("")), "-")).isEqualTo(car.getPosition());
	}
}