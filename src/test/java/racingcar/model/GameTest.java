package racingcar.model;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class GameTest {

	private Game game;

	@BeforeEach
	void setUp() {
		List<Car> cars = Arrays.asList(
			new Car("car0"),
			new Car("car1"),
			new Car("car2")
		);
		game = new Game(cars);
	}

	@DisplayName("게임 생성")
	@Test
	void createGame() {
		List<Car> actual = game.getCars();
		for (int i = 0; i < actual.size(); i++) {
			assertThat(actual.get(i).getName()).isEqualTo("car" + i);
		}
	}

}
