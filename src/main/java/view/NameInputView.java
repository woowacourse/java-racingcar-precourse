package view;

import java.util.ArrayList;

import utils.MissionUtils;

enum NameStringEnums {
	DELIMITER(","), MY_REGEX("^[0-9|a-z|A-Z|ㄱ-ㅎ|ㅏ-ㅣ|가-힣]+$");
	private final String value;

	NameStringEnums(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}
}

enum NameIntEnums {
	SIZE(5);
	private final int value;

	NameIntEnums(int value) {
		this.value = value;
	}

	public int getValue() {
		return this.value;
	}
}

public class NameInputView implements InputView {

	public String getInput(String rawInput) {
		String nameInput = "";
		while (nameInput.isEmpty()) {
			try {
				String nowInput = camp.nextstep.edu.missionutils.Console.readLine();
				ArrayList<String> parsedNowInput = MissionUtils.parseInput(nowInput, NameStringEnums.DELIMITER.getValue());
				MissionUtils.checkEmptyArray(parsedNowInput);
				MissionUtils.checkRegex(parsedNowInput, NameStringEnums.MY_REGEX.getValue());
				MissionUtils.checkDuplication(parsedNowInput);
				MissionUtils.checkLength(parsedNowInput, NameIntEnums.SIZE.getValue());
				nameInput = nowInput;
			} catch (IllegalArgumentException error) {
				System.out.print(error.getMessage());
			}
		}
		return nameInput;
	}
}
