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

import racingcar.utils.Constant;

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
	void 게임_실행() {
		// given
		String input = "test";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		// when
		game.run();

		// then
		assertThat(Constant.INPUT_NAME_MSG).isEqualTo(out.toString().trim());
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
}