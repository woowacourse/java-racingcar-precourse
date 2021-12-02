package racingcar.io.reader;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import racingcar.io.ConsoleDisplay;
import racingcar.model.RacingInfo;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class RacingInfoReaderTest {
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
	@DisplayName("게임 시작 시 정해진 순서대로 값 입력")
	void input_value_in_order() {
		when(Console.readLine()).thenReturn("pobi,woni,jun").thenReturn("5");
		ConsoleDisplay consoleDisplay = mock(ConsoleDisplay.class);
		RacingInfoReader reader =
			new RacingInfoReader(new CarNameReader(consoleDisplay), new TurnValueReader(consoleDisplay));

		reader.read();

		InOrder inOrder = Mockito.inOrder(consoleDisplay);
		inOrder.verify(consoleDisplay).info(CarNameReader.INPUT_MESSAGE);
		inOrder.verify(consoleDisplay).info(TurnValueReader.INPUT_MESSAGE);
	}

	@Test
	@DisplayName("잘못된 값이 입력될 경우 에러 메시지 출력과 재입력")
	void print_error_message_when_input_invalid_value() {
		when(Console.readLine()).thenReturn("123456").thenReturn("pobi,woni,jun").thenReturn("number").thenReturn("6");
		ConsoleDisplay consoleDisplay = mock(ConsoleDisplay.class);
		RacingInfoReader reader =
			new RacingInfoReader(new CarNameReader(consoleDisplay), new TurnValueReader(consoleDisplay));

		reader.read();

		InOrder inOrder = Mockito.inOrder(consoleDisplay);
		inOrder.verify(consoleDisplay).info(CarNameReader.INPUT_MESSAGE);
		inOrder.verify(consoleDisplay).info(CarNameReader.ERROR_MESSAGE);
		inOrder.verify(consoleDisplay).info(CarNameReader.INPUT_MESSAGE);
		inOrder.verify(consoleDisplay).info(TurnValueReader.INPUT_MESSAGE);
		inOrder.verify(consoleDisplay).info(TurnValueReader.ERROR_MESSAGE);
		inOrder.verify(consoleDisplay).info(TurnValueReader.INPUT_MESSAGE);
	}

	@Test
	@DisplayName("읽은 값을 이용해 RacingInfo 생성")
	void create_proper_racing_info() {
		when(Console.readLine()).thenReturn("pobi,woni,jun").thenReturn("5");
		ConsoleDisplay consoleDisplay = mock(ConsoleDisplay.class);
		RacingInfoReader reader =
			new RacingInfoReader(new CarNameReader(consoleDisplay), new TurnValueReader(consoleDisplay));

		RacingInfo info = reader.read();

		assertThat(info.getCarNames()).containsExactlyInAnyOrder("pobi", "woni", "jun");
		assertThat(info.getTurnValue()).isEqualTo(5);
	}
}
