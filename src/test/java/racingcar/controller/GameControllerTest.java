package racingcar.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import racingcar.domain.car.Car;
import racingcar.domain.car.CarSet;
import racingcar.domain.movement.InputMovementStrategy;
import racingcar.domain.round.RacingRound;
import racingcar.service.SprintGameService;

class GameControllerTest {

	@Test
	public void testGameController() {
	    // given
		GameController controller = new SprintGameController(new SprintGameService(new InputMovementStrategy(1)));
	    // when
		RacingRound round = new RacingRound(3);
		CarSet carSet = new CarSet(Arrays.asList(new Car("A"), new Car("B")));
		boolean continuable = controller.play(round, carSet);
		// then
		assertTrue(continuable);
		assertEquals("A : -\nB : -", carSet.toString());
	}
}