package racingcar.domain;

import java.util.Arrays;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameTest {
	List<Car> carList;
	Game game;

	@BeforeEach
	void setUp() {
		carList = Arrays.asList(new Car("자1동차"), new Car("자2동차"), new Car("자3동차"));
		game = new Game(carList);
	}

	@Test
	void 자동차_리스트_삽입() {
		// given, when, then
		Assertions.assertThat(game.getCarList().containsAll(carList)).isTrue();
	}
}
