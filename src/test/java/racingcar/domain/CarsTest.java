package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

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
	void 우승자_1명() {
		// given
		int[] randomNumbers = {5, 0};

		// when
		cars.playOnce(randomNumbers);
		cars.getWinner();

		// then
		assertThat(out.toString().trim()).contains("최종 우승자 : Kim");
	}

	@Test
	void 공동우승() {
		// given
		int[] randomNumbers = {5, 5};

		// when
		cars.playOnce(randomNumbers);
		cars.getWinner();

		// then
		assertThat(out.toString().trim()).contains("최종 우승자 : Kim, Park");
	}
}