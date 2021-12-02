package racingcar;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarTest {
	Car car;
	OutputStream out;

	@BeforeEach
	void beforeEach() {
		car = new Car("name");
		out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
	}

	@Test
	void 출력_확인() {
		// given

		// when
		car.playOnce();

		// then
		String result = out.toString();

		assertThat(result).contains(car.getName());
		assertThat(Collections.frequency(Arrays.asList(result.split("")), "-")).isEqualTo(car.getPosition());
	}
}