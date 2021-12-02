package racingcar.input;

import java.util.ArrayList;

public class NameReceiver {

	private ArrayList<String> makeNameList(String nameString, ArrayList<String> nameList) {
		String[] nameArr = nameString.split(",");
		for (String str : nameArr) {
			nameList.add(str);
		}

		return nameList;
	}
}
