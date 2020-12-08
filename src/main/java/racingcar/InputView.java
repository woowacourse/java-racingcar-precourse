package racingcar;

import java.util.Scanner;
import utils.ValidateUtils;

public class InputView {
	Scanner scanner = new Scanner(System.in);

	public String[] inputCarNames() {
		Message.chooseCarName();
		String carNames = scanner.nextLine();
		String[] carNamesArray = carNames.split(",");
		ValidateUtils.checkCarNameLength(carNamesArray);
		ValidateUtils.checkNameSpace(carNamesArray);
		ValidateUtils.checkDuplicate(carNamesArray);
		return carNamesArray;
	}

	public int inputChooseRacingCount() {
		Message.chooseRacingCount();
		int racingCount = scanner.nextInt();
		ValidateUtils.checkZeroCount(racingCount);
		return racingCount;
	}
}
