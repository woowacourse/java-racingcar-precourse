package racingcar.client;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.config.ClientConfig;

class InputClientTest {

	private ByteArrayOutputStream outputStream;

	@BeforeEach
	public void changeOutput() {
		outputStream = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outputStream));
	}

	@Test
	@DisplayName("프롬프트를 보여주고 입력을 받는다.")
	public void testInputByMessage() {
		// given
		String input = "response";
		InputClient client = ClientConfig.getInputClient();
		// when
		System.setIn(new ByteArrayInputStream(input.getBytes()));
		String response = client.input("some prompt");
		// then
		Assertions.assertEquals("response", response);
	}
}