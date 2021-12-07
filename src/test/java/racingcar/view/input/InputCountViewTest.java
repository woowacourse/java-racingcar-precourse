package racingcar.view.input;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.config.ViewConfig;

class InputCountViewTest {

	private ByteArrayOutputStream outputStream;

	@BeforeEach
	public void changeOutput() {
		outputStream = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outputStream));
	}

	@Test
	@DisplayName("양수를 파싱하여 게임 라운드를 만든다.")
	public void testInputCount() {
		// given
		String input = "123";
		// when
		System.setIn(new ByteArrayInputStream(input.getBytes()));
		InputCountView view = ViewConfig.getInputCountView();
		// then
		assertDoesNotThrow(() -> view.inputCount());
	}

	@Test
	@DisplayName("너무 큰 숫자는 입력할 수 없다.")
	public void testInputCountWithTooBig() {
		// given
		String input = "121241241231231231231233";
		// when
		System.setIn(new ByteArrayInputStream(input.getBytes()));
		InputCountView view = ViewConfig.getInputCountView();
		// then
		assertThrows(NoSuchElementException.class, view::inputCount);
		assertTrue(outputStream.toString().contains("[ERROR]"));
	}



	@Test
	@DisplayName("문자는 입력할 수 없다.")
	public void testInputCountWithNonInteger() {
		String input = "123b";
		// when
		System.setIn(new ByteArrayInputStream(input.getBytes()));
		InputCountView view = ViewConfig.getInputCountView();
		// then
		assertThrows(NoSuchElementException.class, view::inputCount);
		assertTrue(outputStream.toString().contains("[ERROR]"));
	}
}