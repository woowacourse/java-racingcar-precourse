package racingcar.view;

import java.util.ArrayList;
import java.util.StringTokenizer;

import camp.nextstep.edu.missionutils.Console;
import racingcar.utils.InputValidator;

public class InputView {
	public static final String REQUEST_INPUT_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	public static final String DELIMITER = ",";
	private InputValidator inputValidator = new InputValidator();

	public String enterNames() {
		System.out.println(REQUEST_INPUT_NAMES);
		String inputValues = Console.readLine();
		return inputValues;
	}

	public boolean validateNames(ArrayList<String> names) {
		return inputValidator.validateNames(names);
	}

	public ArrayList<String> convertToArrayList(String inputValues) {
		StringTokenizer stringTokenizer = new StringTokenizer(inputValues, DELIMITER);
		ArrayList<String> arrayList = new ArrayList<>();
		while (stringTokenizer.hasMoreTokens()) {
			arrayList.add(stringTokenizer.nextToken());
		}
		return arrayList;
	}

}
