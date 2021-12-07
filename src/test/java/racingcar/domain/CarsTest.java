package racingcar.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarsTest {
	@ParameterizedTest
	@ValueSource(strings = {"", "바흐,,쇼팽"})
	void validateEmptyNameTest(String inputCarNames) {
		assertThrows(IllegalArgumentException.class, () -> {
			Cars cars = Cars.generateCars(inputCarNames);
		});
	}

	@ParameterizedTest
	@ValueSource(strings = {"바흐,쇼팽,라흐마니노프", "도레미파솔라시도,바흐"})
	void validateNameLengthExceedTest(String inputCarNames) {
		assertThrows(IllegalArgumentException.class, () -> {
			Cars cars = Cars.generateCars(inputCarNames);
		});
	}

	@Test
	void validateOnlyOneParticipant() {
		assertThrows(IllegalArgumentException.class, () -> {
			Cars cars = Cars.generateCars("바흐");
		});
	}

	@Test
	void validateDuplicatedName() {
		assertThrows(IllegalArgumentException.class, () -> {
			Cars cars = Cars.generateCars("바흐,바흐,드뷔시");
		});
	}

}