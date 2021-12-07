package racingcar.domain;

import java.util.Arrays;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import racingcar.constant.GameConstants;

public class GameLogTest {
	@Test
	void 로그_추가_가져오기() {
		// given, when
		Game game = new Game(Arrays.asList(new Car("a"), new Car("b")));
		GameLog gameLog = new GameLog();
		gameLog.add(game);
		StringBuilder expected = new StringBuilder();
		game.getCarList()
			.forEach(car -> expected.append(car.getName())
				.append(GameConstants.CarStringConversion.INFIX.getString())
				.append(GameConstants.GameStringConversion.GAME_RESULT_POSTFIX.getString()));
		// then
		Assertions.assertThat(gameLog.get(game)).contains(expected);
	}
}
