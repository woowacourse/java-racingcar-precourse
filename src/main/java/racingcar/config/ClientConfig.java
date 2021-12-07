package racingcar.config;

import racingcar.client.ConsoleErrorClient;
import racingcar.client.ConsoleInputClient;
import racingcar.client.ConsoleOutputClient;
import racingcar.client.ErrorClient;
import racingcar.client.InputClient;
import racingcar.client.OutputClient;

public class ClientConfig {
	public static InputClient getInputClient() {
		return new ConsoleInputClient(getOutputClient());
	}

	public static OutputClient getOutputClient() {
		return new ConsoleOutputClient();
	}

	public static ErrorClient getErrorClient() {
		return new ConsoleErrorClient();
	}
}
