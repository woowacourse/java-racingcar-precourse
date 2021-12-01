package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class CarNameReaderTest {
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
	@DisplayName("자동차 이름 입력 전에 안내 메시지 출력")
	void display_input_message() {
		when(Console.readLine()).thenReturn("pobi,jun,woni");
		ConsoleDisplay consoleDisplay = mock(ConsoleDisplay.class);
		CarNameReader carNameReader = new CarNameReader(consoleDisplay);

		carNameReader.read();

		verify(consoleDisplay).info(CarNameReader.INPUT_MESSAGE);
	}

	@Test
	@DisplayName("자동차 이름은 콤마로 구분")
	void split_car_name_by_comma() {
		when(Console.readLine()).thenReturn("pobi,jun,woni");
		ConsoleDisplay consoleDisplay = mock(ConsoleDisplay.class);
	    CarNameReader carNameReader = new CarNameReader(consoleDisplay);

		List<String> names = carNameReader.read();

		assertThat(names).containsExactlyInAnyOrder("pobi", "jun", "woni");
	}
}
