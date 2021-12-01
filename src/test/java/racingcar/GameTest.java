package racingcar;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GameTest {

	Game game;

	@BeforeEach
	void 게임_생성() {
		game = new Game();
	}

	@Test
	void 게임_실행() {
		OutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		game.run();
		Assertions.assertThat(Constant.START_GAME_MSG).isEqualTo(out.toString().trim());
	}
}