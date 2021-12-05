package racingcar.service;

import java.util.stream.Stream;

import racingcar.view.OutputView;

public class NameService {
	final static String DELIMITER = ",";

	// 입력 받은 문자열에서 자동차들의 이름을 추출한다.
	public static String[] getCarNames(String names) {
		String[] result;
		while (true) {
			try {
				result = convertToArray(names);
				break;
			} catch (IllegalArgumentException e) {
				OutputView.printError(e.getMessage());
			}
		}
		return result;
	}

	public static String[] convertToArray(String names) {
		ValidationService.checkCarNames(names, DELIMITER);
		return makeClearCarNames(names.split(DELIMITER));
	}

	public static String[] makeClearCarNames(String[] names) {
		String[] result = Stream.of(names).map(String::trim).toArray(String[]::new);
		ValidationService.checkDuplicatedCarName(result);
		ValidationService.checkEachCarName(result);
		return result;
	}
}
