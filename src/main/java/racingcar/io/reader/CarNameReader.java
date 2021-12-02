package racingcar.io.reader;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import racingcar.io.ConsoleDisplay;

public class CarNameReader extends Reader<List<String>>{
	public static final String INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	public static final String ERROR_MESSAGE = "[ERROR] 자동차 이름은 5글자 이하여야 합니다.";
	private static final int BOUNDARY_VALUE = 5;
	private static final String DELIMITER = ",";

	public CarNameReader(ConsoleDisplay consoleDisplay) {
		super(consoleDisplay, INPUT_MESSAGE, ERROR_MESSAGE);
	}

	@Override
	protected boolean isValid(String input) {
		return Stream.of(input.split(DELIMITER)).allMatch(name -> isLessThanBoundaryLength(name));
	}

	@Override
	protected List<String> handleInputValue(String input) {
		return Arrays.asList(input.split(DELIMITER));
	}

	private boolean isLessThanBoundaryLength(String name) {
		return name.length() <= BOUNDARY_VALUE;
	}
}
