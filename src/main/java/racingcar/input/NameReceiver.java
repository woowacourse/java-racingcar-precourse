package racingcar.input;

import java.util.ArrayList;

import camp.nextstep.edu.missionutils.Console;
import racingcar.validator.NameValidator;

public class NameReceiver {

	private static final String INPUT_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	private static final String NAME_ERROR_MESSAGE = "[ERROR] 적절하지 않은 자동차 이름 입력되었습니다.";

	NameValidator nameValidator = new NameValidator();

	public ArrayList<String> receive() {
		ArrayList<String> nameList = null;

		boolean errorSwitch = true;
		while (errorSwitch) {
			System.out.println(INPUT_NAME_MESSAGE);
			String nameString = Console.readLine();

			nameList = new ArrayList<>();
			nameList = makeNameList(nameString, nameList);

			try {
				nameValidator.validate(nameList);
				errorSwitch = false;
			} catch (IllegalArgumentException illegalArgumentException) {
				System.out.println(NAME_ERROR_MESSAGE);
				errorSwitch = true;
			}
		}

		return nameList;
	}

	private ArrayList<String> makeNameList(String nameString, ArrayList<String> nameList) {
		String[] nameArr = nameString.split(",");
		for (String str : nameArr) {
			nameList.add(str);
		}

		return nameList;
	}
}
