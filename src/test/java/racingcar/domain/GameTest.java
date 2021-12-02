package racingcar.domain;

import static racingcar.constant.GameConstants.GameStringConversion.*;

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

	@Test
	void 게임_한판_진행() {
		// given, when
		game.runSingle();
		List<Car> list = game.getCarList();
		int farthestPosition = 0;
		for (Car car : list)
			farthestPosition = Math.max(farthestPosition, car.getPosition());
		final int finalFarthestPosition = farthestPosition;

		//then
		Assertions.assertThat(game.getCarList()
				.stream()
				.filter(car -> car.getPosition() == finalFarthestPosition)
				.anyMatch(winnerCandidate -> game.getWinnerList().contains(winnerCandidate)))
			.isTrue();
	}

	@Test
	void 게임_여러판_진행() {
		// given, when
		game.runMultiple(5);
		List<Car> list = game.getCarList();
		int farthestPosition = 0;
		for (Car car : list)
			farthestPosition = Math.max(farthestPosition, car.getPosition());
		final int finalFarthestPosition = farthestPosition;

		//then
		Assertions.assertThat(game.getCarList()
				.stream()
				.filter(car -> car.getPosition() == finalFarthestPosition)
				.anyMatch(winnerCandidate -> game.getWinnerList().contains(winnerCandidate)))
			.isTrue();
	}

	@Test
	void 게임_결과_문자열_변환() {
		// given, when
		game.runMultiple(5);
		StringBuilder expectedWinnerStringBuilder = new StringBuilder();
		game.getWinnerList().forEach(winner -> {
			expectedWinnerStringBuilder.append(winner.getName()).append(GAME_WINNER_DELIMITER.getString());
		});
		String expectedWinnerString = expectedWinnerStringBuilder.substring(0,
			expectedWinnerStringBuilder.length() - GAME_WINNER_DELIMITER.getString().length());

		//then
		carList.forEach(car -> Assertions.assertThat(game.toString()).contains(car.toString()));
		Assertions.assertThat(game.toString()).contains(GAME_RESULT_HINT.getString());
		Assertions.assertThat(game.toString()).contains(expectedWinnerString);
	}
}
