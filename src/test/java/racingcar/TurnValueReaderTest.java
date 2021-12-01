package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class TurnValueReaderTest {
	@Test
	@DisplayName("입력 전 안내 메시지 출력")
	void print_message_before_input() {
		ConsoleDisplay consoleDisplay = mock(ConsoleDisplay.class);
	    TurnValueReader turnValueReader = new TurnValueReader(consoleDisplay);

		turnValueReader.read();

		verify(consoleDisplay).info(TurnValueReader.INPUT_MESSAGE);
	}
}
