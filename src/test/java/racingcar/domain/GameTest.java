package racingcar.domain;

import static racingcar.constant.GameConstants.GameStringConversion.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameTest {
	List<String> carNameList;
	Game game;

	@BeforeEach
	void setUp() {
		carNameList = Arrays.asList("자1동차", "자2동차", "자3동차");
		game = new Game(carNameList);
	}

	@Test
	void 자동차_리스트_삽입() {
		// given, when
		List<String> carNameListFromGameClass = game.getCarList()
			.stream()
			.map(Car::getName)
			.collect(Collectors.toList());
		// then
		Assertions.assertThat(carNameListFromGameClass.containsAll(carNameList)).isTrue();
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
				.anyMatch(winnerCandidate -> game.getWinnerCandidateList().contains(winnerCandidate)))
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
				.anyMatch(winnerCandidate -> game.getWinnerCandidateList().contains(winnerCandidate)))
			.isTrue();
	}

	@Test
	void 게임_결과_문자열_변환() {
		// given, when
		game.runMultiple(5);
		StringBuilder expectedWinnerStringBuilder = new StringBuilder();
		game.getWinnerCandidateList()
			.forEach(winner -> expectedWinnerStringBuilder.append(winner.getName())
				.append(GAME_WINNER_DELIMITER.getString()));
		String expectedWinnerString = expectedWinnerStringBuilder.substring(0,
			expectedWinnerStringBuilder.length() - GAME_WINNER_DELIMITER.getString().length());

		//then
		carNameList.forEach(car -> Assertions.assertThat(game.toString()).contains(car.toString()));
		Assertions.assertThat(game.toString()).contains(GAME_RESULT_HINT.getString());
		Assertions.assertThat(game.toString()).contains(expectedWinnerString);
	}

	@Test
	void 게임_결과_문자열_변환_2회() {
		// given, when, then
		게임_결과_문자열_변환();
		게임_결과_문자열_변환();
	}
}
