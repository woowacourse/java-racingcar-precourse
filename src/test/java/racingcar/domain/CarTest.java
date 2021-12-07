package racingcar.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MustMoveRule implements MoveRule {
	@Override
	public boolean isMovable(int number) {
		return true;
	}
}

class NeverMoveRule implements MoveRule {
	@Override
	public boolean isMovable(int number) {
		return false;
	}
}

class CarTest {
	Car car;
	MoveRule defaultRule = new DefaultRule();

	@ParameterizedTest
	@ValueSource(ints = {4, 5, 6, 7, 8, 9})
	void isMovableWhenRandomNumberGreaterThanOrEqualToThreshold(int randomNumber) {
		MoveRule mustMoveRule = new MustMoveRule();
		car = new Car("이것은 차다", mustMoveRule);

		Assertions.assertTrue(defaultRule.isMovable(randomNumber));

		car.moveAccordingToRule();
		Assertions.assertEquals(1, car.getPosition());
	}

	@ParameterizedTest
	@ValueSource(ints = {0, 1, 2, 3})
	void isNotMovedWhenRandomNumberLessThanThreshold(int randomNumber) {
		MoveRule neverMoveRule = new NeverMoveRule();
		car = new Car("이것은 차다", neverMoveRule);

		Assertions.assertFalse(defaultRule.isMovable(randomNumber));

		car.moveAccordingToRule();
		Assertions.assertEquals(0, car.getPosition());

	}
}