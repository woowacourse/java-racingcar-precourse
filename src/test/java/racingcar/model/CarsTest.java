package racingcar.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import racingcar.model.Car;
import racingcar.model.Cars;

public class CarsTest {

	@DisplayName("우승자 구하기")
	@ParameterizedTest
	@MethodSource("winnersTestSource")
	void winners(List<Car> carList, int winnerCount) {
		Cars cars = new Cars(carList);
		assertEquals(winnerCount, cars.getRacingWinners().size());
	}

	private static Stream<Arguments> winnersTestSource() {
		return Stream.of(
			Arguments.of(
				Arrays.asList(new Car("car1"), new Car("car2"), new Car("car3")),
				3
			),
			Arguments.of(
				Arrays.asList(
					new Car("car1", 1), new Car("car2", 0), new Car("car3", 0)),
				1
			),
			Arguments.of(
				Arrays.asList(
					new Car("car1", 1), new Car("car2", 1), new Car("car3")),
				2
			)
		);
	}
}
