package racingcar.view;

import static racingcar.constant.GameConstants.GameStringConversion.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import racingcar.domain.Car;
import racingcar.domain.Game;

class OutputViewTest {
	List<String> carNameList;
	List<Car> carList;
	Game game;
	ByteArrayOutputStream byteArrayOutputStream;
	PrintStream printStream;

	@BeforeEach
	void setUp() {
		carNameList = Arrays.asList("자1동차", "자2동차", "자3동차");
		carList = carNameList.stream().map(Car::new).collect(Collectors.toList());
		game = new Game(carList);
		byteArrayOutputStream = new ByteArrayOutputStream();
		printStream = new PrintStream(byteArrayOutputStream);
		System.setOut(printStream);
	}

	@Test
	void 게임_결과_출력() {
		// given, when
		game.runMultiple(5);

		StringBuilder expectedWinnerStringBuilder = new StringBuilder();
		Car farthestCar = Collections.max(game.getCarList(), Comparator.comparingInt(Car::getPosition));
		game.getCarList()
			.stream()
			.filter(car -> car.getPosition() == farthestCar.getPosition())
			.collect(Collectors.toList())
			.forEach(winner -> expectedWinnerStringBuilder.append(winner.getName()).append(GAME_WINNER_DELIMITER.getString()));
		String expectedWinnerString = expectedWinnerStringBuilder.substring(0,
			expectedWinnerStringBuilder.length() - GAME_WINNER_DELIMITER.getString().length());

		//then
		OutputView.printGameResult(game);
		carNameList.forEach(car -> Assertions.assertThat(byteArrayOutputStream.toString()).contains(car.toString()));
		Assertions.assertThat(byteArrayOutputStream.toString()).contains(GAME_RESULT_HINT.getString());
		Assertions.assertThat(byteArrayOutputStream.toString()).contains(expectedWinnerString);
	}
}