package racingcar.receiver;

import java.util.ArrayList;

import camp.nextstep.edu.missionutils.Console;
import racingcar.validator.NameValidator;

public class NameReceiver {

	public ArrayList<String> receive() {
		ArrayList<String> nameList = null;

		boolean errorSwitch = true;
		while (errorSwitch) {
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
