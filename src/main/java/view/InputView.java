package view;

import java.util.Scanner;

public class InputView {
	private static final Scanner scanner = new Scanner(System.in);
	private static final String GET_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	private static final String GET_TRY_NUMBER_MESSAGE = "시도할 회수는 몇회인가요?";

	public static String carNames() {
		System.out.println(GET_CAR_NAMES_MESSAGE);
		return scanner.nextLine();
	}

	public static int tryNumber() {
		System.out.println(GET_TRY_NUMBER_MESSAGE);
		return scanner.nextInt();
	}
}
