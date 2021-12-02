package racingcar;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GameTest {

	Game game;
	OutputStream out;

	@BeforeEach
	void 게임_생성() {
		game = new Game();
		out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
	}

	@Test
	void 자동차_생성() throws Exception {
		Method inputName = Game.class.getDeclaredMethod("inputName");
		inputName.setAccessible(true);

		// given
		String input = "test1, test2";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		// when
		inputName.invoke(game);

		// then
		List<Car> carList = game.getCarList();
		assertThat(carList.size()).isEqualTo(2);
	}

	@Test
	void 숫자_입력() throws Exception {
		Method inputRunNumber = Game.class.getDeclaredMethod("inputRunNumber");
		inputRunNumber.setAccessible(true);

		// given
		int input = 5;
		InputStream in = new ByteArrayInputStream(Integer.toString(input).getBytes());
		System.setIn(in);

		// when
		inputRunNumber.invoke(game);

		// then
		assertThat(game.getRunNumber()).isEqualTo(input);
	}
}