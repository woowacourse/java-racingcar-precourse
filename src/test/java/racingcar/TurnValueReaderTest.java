package racingcar;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import static org.mockito.Mockito.*;

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
}
