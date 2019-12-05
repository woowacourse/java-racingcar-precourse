package view;

import java.util.Scanner;

public class InputView {
	private static final Scanner scanner = new Scanner(System.in);
	private static final String GET_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

	public static String carNames() {
		System.out.println(GET_CAR_NAMES_MESSAGE);
		return scanner.nextLine();
	}
}
