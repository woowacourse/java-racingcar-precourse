package view;

import java.util.ArrayList;
import java.util.Arrays;

import utils.MissionUtils;

enum TurnStringEnums {
	TURN_REGEX("^[0-9]+$");
	private final String value;

	TurnStringEnums(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}
}

enum TurnIntEnums {
	TURN_MIN(0);
	private final int value;

	TurnIntEnums(int value) {
		this.value = value;
	}

	public int getValue() {
		return this.value;
	}
}

public class TurnInputView implements InputView{

	public String getInput(String rawInput) {
		String turnInput = "";
		while (turnInput.isEmpty()) {
			try {
				String nowInput = camp.nextstep.edu.missionutils.Console.readLine();
				ArrayList<String> nowInputArray = new ArrayList<>(Arrays.asList(nowInput));
				MissionUtils.checkRegex(nowInputArray, TurnStringEnums.TURN_REGEX.getValue());
				MissionUtils.checkOverSomeInt(nowInput, TurnIntEnums.TURN_MIN.getValue());
				turnInput = nowInput;
			} catch (IllegalArgumentException error) {
				System.out.print(error.getMessage());
			}
		}
		return turnInput;
	}
}
