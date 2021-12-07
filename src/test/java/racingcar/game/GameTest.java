package racingcar.game;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import racingcar.config.ViewConfig;
import racingcar.controller.SprintGameController;
import racingcar.domain.movement.InputMovementStrategy;
import racingcar.service.SprintGameService;

class GameTest {

	private ByteArrayOutputStream outputStream;

	@BeforeEach
	public void changeOutput() {
		outputStream = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outputStream));
	}

	@Test
	public void testGame() {
		// given
		System.setIn(new ByteArrayInputStream("a,b,c\n3".getBytes()));
		Game game = new RacingGame(
			ViewConfig.getInputView(),
			ViewConfig.getOutputView(),
			new SprintGameController(new SprintGameService(new InputMovementStrategy(1)))
		);
		// when
		game.play();
		// then
		assertEquals("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n"
			+ "시도할 회수는 몇회인가요?\n"
			+ "실행 결과\n"
			+ "a : -\n"
			+ "b : -\n"
			+ "c : -\n"
			+ "\n"
			+ "a : --\n"
			+ "b : --\n"
			+ "c : --\n"
			+ "\n"
			+ "a : ---\n"
			+ "b : ---\n"
			+ "c : ---\n"
			+ "\n"
			+ "최종 우승자 : a, b, c\n", outputStream.toString());
	}
}