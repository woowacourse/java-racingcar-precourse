package racingcar;

import java.util.Arrays;
import java.util.List;

public class CarNameReader extends Reader<List<String>>{
	public static final String INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

	public CarNameReader(ConsoleDisplay consoleDisplay) {
		super(consoleDisplay, INPUT_MESSAGE);
	}

	@Override
	protected List<String> handleInputValue(String input) {
		return Arrays.asList(input.split(","));
	}
}
