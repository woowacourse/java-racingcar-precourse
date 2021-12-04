package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class PlayerInput {
	private static final String INPUT_MESSAGE_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

	public List<String> getCarNames() {
		String input = getCarNamesInput();
		List<String> carNames = convertInputToCarNamesList(input);
		return carNames;
	}

	private String getCarNamesInput() {
		System.out.println(INPUT_MESSAGE_CAR_NAMES);
		String input = Console.readLine();
		return input;
	}

	private List<String> convertInputToCarNamesList(String input) {
		List<String> carNames = new ArrayList<>();
		StringTokenizer stringTokenizer = new StringTokenizer(input, ",");
		while (stringTokenizer.hasMoreTokens()) {
			String newName = stringTokenizer.nextToken();
			carNames.add(newName);
		}
		return carNames;
	}
}
