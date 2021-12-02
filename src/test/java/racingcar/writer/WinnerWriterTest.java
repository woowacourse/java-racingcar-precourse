package racingcar.writer;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.ConsoleDisplay;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class WinnerWriterTest {
	@Test
	@DisplayName("단독 우승자 출력")
	void write_single_winner() {
		ConsoleDisplay consoleDisplay = mock(ConsoleDisplay.class);
	    WinnerWriter winnerWriter = new WinnerWriter(consoleDisplay);

		winnerWriter.write("pobi");

		verify(consoleDisplay).info("최종 우승자 : pobi");
	}
}
