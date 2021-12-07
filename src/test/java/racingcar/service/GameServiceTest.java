package racingcar.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import racingcar.domain.car.Car;
import racingcar.domain.car.CarSet;
import racingcar.domain.movement.InputMovementStrategy;

class GameServiceTest {

	@Test
	public void testGameService() {
	    // given
		GameService service = new SprintGameService(new InputMovementStrategy(3));
		CarSet carSet = new CarSet(Arrays.asList(new Car("A"), new Car("B")));
	    // when
		service.play(carSet);
	    // then
		assertEquals("A : ---\nB : ---", carSet.toString());
	}
}