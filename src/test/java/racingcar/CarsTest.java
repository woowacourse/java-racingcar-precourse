package racingcar;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class CarsTest {

	@Test
	void findWinner() {
		String[] carNames = {"a", "b", "c"};
		Cars cars = new Cars(carNames);
		for (int i = 0; i < 5; i++) {
			cars.move();
		}
		cars.printAll();
		cars.findWinner();
	}
}