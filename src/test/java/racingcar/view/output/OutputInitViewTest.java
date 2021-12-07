package racingcar.view.output;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.config.ViewConfig;

class OutputInitViewTest {

	private ByteArrayOutputStream outputStream;

	@BeforeEach
	public void changeOutput() {
		outputStream = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outputStream));
	}

	@Test
	@DisplayName("게임의 시작을 알리는 '실행 결과'를 출력해야 한다.")
	public void testShowInitMessage() {
	    // given
	    OutputInitView view = ViewConfig.getOutputInitView();
	    // when
	    view.showInit();
	    // then
		assertEquals("실행 결과\n", outputStream.toString());
	}
}