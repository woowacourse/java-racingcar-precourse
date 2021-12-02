package racingcar.io.writer;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.io.ConsoleDisplay;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class WinnerWriterTest {
	@Test
	@DisplayName("단독 우승자 출력")
	void write_single_winner() {
		ConsoleDisplay consoleDisplay = mock(ConsoleDisplay.class);
		WinnerWriter winnerWriter = new WinnerWriter(consoleDisplay);

		winnerWriter.write(Arrays.asList("pobi"));

		verify(consoleDisplay).info("최종 우승자 : pobi");
	}

	@Test
	@DisplayName("공동 우승자 출력")
	void write_co_winners() {
		ConsoleDisplay consoleDisplay = mock(ConsoleDisplay.class);
		WinnerWriter winnerWriter = new WinnerWriter(consoleDisplay);

		winnerWriter.write(Arrays.asList("pobi", "jun"));

		verify(consoleDisplay).info("최종 우승자 : pobi, jun");
	}
}
