package racingcar.writer;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.ConsoleDisplay;
import racingcar.model.ProceedResult;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ProceedResultWriterTest {
	@Test
	@DisplayName("중간 결과 출력")
	void print_with_progress_bar() {
		ConsoleDisplay consoleDisplay = mock(ConsoleDisplay.class);
		ProceedResultWriter writer = new ProceedResultWriter(consoleDisplay);

		writer.write(Arrays.asList(ProceedResult.of("pobi", 4), ProceedResult.of("jun", 2)));

		verify(consoleDisplay).info("pobi : ----");
		verify(consoleDisplay).info("jun : --");
		verify(consoleDisplay).info("");
	}
}
