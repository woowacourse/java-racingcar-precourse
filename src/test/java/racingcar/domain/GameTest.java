package racingcar.domain;

import static org.mockito.ArgumentMatchers.*;
import static racingcar.constant.GameConstants.GameStringConversion.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class GameTest {
	List<String> carNameList;
	List<Car> carSpyList;
	Game spyGame;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
		carNameList = Arrays.asList("자1동차", "자2동차", "자3동차");
		carSpyList = carNameList.stream().map(name -> Mockito.spy(new Car(name))).collect(Collectors.toList());
		spyGame = Mockito.spy(new Game(carSpyList));
	}

	@Test
	void 게임_한판_진행() {
		// given, when
		spyGame.runSingle();

		// then
		carSpyList.forEach(carMock -> Mockito.verify(carMock, Mockito.atLeastOnce()).moveByNumber(anyInt()));
	}

	@Test
	void 게임_여러판_진행() {
		// given, when
		spyGame.runMultiple(5);

		Mockito.verify(spyGame, Mockito.times(5)).runSingle();
	}

	@Test
	void 게임_결과_문자열_변환() {
		// given, when
		spyGame.runMultiple(5);
		StringBuilder expectedWinnerStringBuilder = new StringBuilder();
		Car farthestCar = Collections.max(spyGame.getCarList(), Comparator.comparingInt(Car::getPosition));
		spyGame.getCarList()
			.stream()
			.filter(car -> car.getPosition() == farthestCar.getPosition())
			.collect(Collectors.toList())
			.forEach(winner -> expectedWinnerStringBuilder.append(winner.getName())
				.append(GAME_WINNER_DELIMITER.getString()));
		String expectedWinnerString = expectedWinnerStringBuilder.substring(0,
			expectedWinnerStringBuilder.length() - GAME_WINNER_DELIMITER.getString().length());

		//then
		carNameList.forEach(car -> Assertions.assertThat(spyGame.toString()).contains(car));
		Assertions.assertThat(spyGame.toString()).contains(GAME_RESULT_HINT.getString());
		Assertions.assertThat(spyGame.toString()).contains(expectedWinnerString);
	}

	@Test
	void 게임_결과_문자열_변환_2회() {
		// given, when, then
		게임_결과_문자열_변환();
		게임_결과_문자열_변환();
	}
}
