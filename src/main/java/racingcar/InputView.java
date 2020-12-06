package racingcar;

import java.util.Scanner;

public class InputView {
	Scanner scanner = new Scanner(System.in);
	String carNames = scanner.nextLine();
	String[] carNamesArray = carNames.split(carNames, ',');
}
