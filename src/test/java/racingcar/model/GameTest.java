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

	@DisplayName("게임 실행")
	@Test
	void play() {
		game.play(() -> 5, i -> i >= 4);
		for (Car car : game.getCars()) {
			assertThat(car.getPosition()).isEqualTo(1);
		}
	}

	@DisplayName("우승자들")
	@Test
	void winners() {
		List<Car> cars = game.getCars();
		List<Car> winners = Arrays.asList(
			cars.get(0),
			cars.get(1)
		);
		winners.get(0).move();
		winners.get(1).move();

		game.play(() -> 5, i -> i >= 4);

		assertThat(game.winners().containsAll(winners)).isTrue();
	}
}
