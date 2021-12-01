package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class CarNameReaderTest {

	@Test
	@DisplayName("자동차 이름 입력 전에 안내 메시지 출력")
	void display_input_message() {
		ConsoleDisplay consoleDisplay = mock(ConsoleDisplay.class);
		CarNameReader carNameReader = new CarNameReader(consoleDisplay);

		carNameReader.read();

		verify(consoleDisplay).info(CarNameReader.INPUT_MESSAGE);
	}
}
