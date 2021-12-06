package racingcar.io;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleReader {

	private static final String READ_RACER_SYSTEM_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	private static final String READ_TRY_COUNT_SYSTEM_MESSAGE = "시도할 회수는 몇회인가요?";

	private final ConsolePrinter printer;

	public ConsoleReader(ConsolePrinter printer) {
		this.printer = printer;
	}

	public String readRacer() {
		printer.print(READ_RACER_SYSTEM_MESSAGE);
		return readLine();
	}

	public String readTryCount() {
		printer.print(READ_TRY_COUNT_SYSTEM_MESSAGE);
		return readLine();
	}

	private String readLine() {
		return Console.readLine();
	}
}
