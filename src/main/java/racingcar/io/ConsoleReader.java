package racingcar.io;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleReader {

	private static final String READ_RACER_SYSTEM_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

	private final ConsolePrinter writer;

	public ConsoleReader(ConsolePrinter writer) {
		this.writer = writer;
	}

	public String readRacer() {
		writer.writeLine(READ_RACER_SYSTEM_MESSAGE);
		return readLine();
	}

	private String readLine() {
		return Console.readLine();
	}
}
