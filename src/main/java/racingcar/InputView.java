package racingcar;

import java.util.Scanner;

public class InputView {
	Scanner scanner = new Scanner(System.in);

	public String[] inputCarNames() {
		Message.chooseCarName();
		String carNames = scanner.nextLine();
		String[] carNamesArray = carNames.split(",");

		return carNamesArray;
	}

	public int inputChooseRacingCount() {
		Message.chooseRacingCount();
		int racingCount = scanner.nextInt();
		
		return racingCount;
	}
}
