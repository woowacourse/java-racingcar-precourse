package racingcar.client;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.config.ClientConfig;

class OutputClientTest {

	private ByteArrayOutputStream outputStream;

	@BeforeEach
	public void changeOutput() {
		outputStream = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outputStream));
	}

	@Test
	@DisplayName("주어진 문자열을 출력한다.")
	public void testOutputMessage() {
		// given
		String output = "hello world!";
		// when
		OutputClient client = ClientConfig.getOutputClient();
		client.output(output);
		// then
		assertEquals("hello world!\n", outputStream.toString());
	}
}