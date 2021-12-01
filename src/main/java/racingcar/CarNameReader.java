package racingcar;

public class CarNameReader {
	public static final String INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	private final ConsoleDisplay consoleDisplay;

	public CarNameReader(ConsoleDisplay consoleDisplay) {
		this.consoleDisplay = consoleDisplay;
	}

	public String read() {
		consoleDisplay.info(INPUT_MESSAGE);
		return null;
	}
}
