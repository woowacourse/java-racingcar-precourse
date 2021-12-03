package racingcar.input;

import java.util.ArrayList;

import camp.nextstep.edu.missionutils.Console;
import racingcar.validator.NameValidator;

public class NameReceiver {

	private static final String INPUT_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

	public ArrayList<String> receive() {
		ArrayList<String> nameList = null;

		boolean errorSwitch = true;
		while (errorSwitch) {
			System.out.println(INPUT_NAME_MESSAGE);
			String nameString = Console.readLine();

			nameList = makeNameList(nameString);

			errorSwitch = new NameValidator().validate(nameList);
		}

		return nameList;
	}

	private ArrayList<String> makeNameList(String nameString) {
		ArrayList<String> nameList = new ArrayList<>();

		for (String str : nameString.split(",")) {
			nameList.add(str);
		}

		return nameList;
	}
}
