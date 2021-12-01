package racingcar.view;

import java.util.ArrayList;
import java.util.StringTokenizer;

import camp.nextstep.edu.missionutils.Console;
import racingcar.utils.InputValidator;

public class InputView {
	public static final String REQUEST_INPUT_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	public static final String DELIMITER = ",";
	private InputValidator inputValidator = new InputValidator();

	public ArrayList<String> enterNames() {
		boolean needProperNames = true;
		ArrayList<String> names = new ArrayList<>();

		System.out.println(REQUEST_INPUT_NAMES);
		while (needProperNames) {
			String inputValues = Console.readLine();
			names = convertToArrayList(inputValues);
			needProperNames = inputValidator.validateNames(names);
		}
		return names;
	}

	private ArrayList<String> convertToArrayList(String inputValues) {
		StringTokenizer stringTokenizer = new StringTokenizer(inputValues, DELIMITER);
		ArrayList<String> arrayList = new ArrayList<>();
		while (stringTokenizer.hasMoreTokens()) {
			arrayList.add(stringTokenizer.nextToken());
		}
		return arrayList;
	}

}
