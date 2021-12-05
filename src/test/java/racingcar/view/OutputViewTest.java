package racingcar.view;

import static racingcar.constant.GameConstants.GameStringConversion.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import racingcar.domain.Car;
import racingcar.domain.Game;

class OutputViewTest {
	List<Car> carList;
	Game game;
	ByteArrayOutputStream byteArrayOutputStream;
	PrintStream printStream;

	@BeforeEach
	void setUp() {
		carList = Arrays.asList(new Car("자1동차"), new Car("자2동차"), new Car("자3동차"));
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
		game.getWinnerCandidateList()
			.forEach(winner -> expectedWinnerStringBuilder.append(winner.getName())
				.append(GAME_WINNER_DELIMITER.getString()));
		String expectedWinnerString = expectedWinnerStringBuilder.substring(0,
			expectedWinnerStringBuilder.length() - GAME_WINNER_DELIMITER.getString().length());

		//then
		OutputView.printGameResult(game);
		carList.forEach(car -> Assertions.assertThat(byteArrayOutputStream.toString()).contains(car.toString()));
		Assertions.assertThat(byteArrayOutputStream.toString()).contains(GAME_RESULT_HINT.getString());
		Assertions.assertThat(byteArrayOutputStream.toString()).contains(expectedWinnerString);
	}
}