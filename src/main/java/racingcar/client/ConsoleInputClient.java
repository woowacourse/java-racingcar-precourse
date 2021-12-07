package racingcar.client;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleInputClient implements InputClient {

	private final OutputClient outputClient;

	public ConsoleInputClient(OutputClient outputClient) {
		this.outputClient = outputClient;
	}

	public String input(String prompt) {
		outputClient.output(prompt);
		return Console.readLine();
	}
}
