package racingcar.client;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.config.ClientConfig;

class ErrorClientTest {

	private ByteArrayOutputStream outputStream;

	@BeforeEach
	public void changeOutput() {
		outputStream = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outputStream));
	}

	@Test
	@DisplayName("에러 메시지를 출력한다.")
	public void testErrorMessage() {
		// given
		String message = "unexpected error!!";
		ErrorClient errorClient = ClientConfig.getErrorClient();
		// when
		errorClient.error(message);
		// then
		assertEquals("[ERROR] unexpected error!!\n", outputStream.toString());
	}
}