package racingcar.io.reader;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import camp.nextstep.edu.missionutils.Console;

import racingcar.io.ConsoleDisplay;

public class TurnValueReaderTest {
	MockedStatic<Console> consoleMockedStatic;

	@BeforeEach
	public void setUp() throws Exception {
		consoleMockedStatic = mockStatic(Console.class);
	}

	@AfterEach
	public void tearDown() throws Exception {
		consoleMockedStatic.close();
	}

	@Test
	@DisplayName("입력 전 안내 메시지 출력")
	void print_message_before_input() {
		when(Console.readLine()).thenReturn("0");
		ConsoleDisplay consoleDisplay = mock(ConsoleDisplay.class);
		TurnValueReader turnValueReader = new TurnValueReader(consoleDisplay);

		turnValueReader.read();

		verify(consoleDisplay).info(TurnValueReader.INPUT_MESSAGE);
	}

	@Test
	@DisplayName("시도 회수 읽기")
	void read_turn_value() {
		when(Console.readLine()).thenReturn("12");
		ConsoleDisplay consoleDisplay = mock(ConsoleDisplay.class);
		TurnValueReader turnValueReader = new TurnValueReader(consoleDisplay);

		int value = turnValueReader.read();

		assertThat(value).isEqualTo(12);
	}

	@Test
	@DisplayName("숫자가 아닌 회수 값 읽기")
	void read_invalid_turn_value() {
		when(Console.readLine()).thenReturn("number");
		ConsoleDisplay consoleDisplay = mock(ConsoleDisplay.class);
		TurnValueReader turnValueReader = new TurnValueReader(consoleDisplay);

		IllegalArgumentException exception =
			assertThrows(IllegalArgumentException.class, () -> turnValueReader.read());

		assertThat(exception.getMessage()).isEqualTo(TurnValueReader.ERROR_MESSAGE);
	}
}
