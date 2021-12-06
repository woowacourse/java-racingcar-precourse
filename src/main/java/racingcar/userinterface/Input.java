package racingcar.userinterface;

import camp.nextstep.edu.missionutils.Console;

public class Input {
	private String carNames;

	String getCarNames() {
		System.out.println("자동차 이름을 입력해 주세요.");
		boolean passed = false;
		while (!passed) {
			initCars();
			passed = true;
		}
		return carNames;
	}

	private void initCars() {
		String input = Console.readLine();
		if (isValidCarNames(input)) {
			this.carNames = input;
		}
		throw new IllegalArgumentException();
	}

	private boolean isValidCarNames(String string) {
		return string.matches("^[a-zA-Z][a-zA-Z0-9,]*");
	}

	private int repeatNum;

	int getRepeatNum() {
		System.out.println("반복횟수 입력해 주세요.");
		boolean passed = false;
		while (!passed) {
			initNum();
			passed = true;
		}
		return repeatNum;
	}

	private void initNum() {
		String input = Console.readLine();
		if (isValidNum(input)) {
			this.repeatNum = Integer.parseInt(input);
		}
		throw new IllegalArgumentException();
	}

	private boolean isValidNum(String string) {
		return string.matches("^[1-9][0-9]*");
	}
}

/*
 비슷한 내용이 너무 많아서 클래스화 하고 싶다.
 	private String carNames;  // 1. 상속 클래스에 선언할 변수

	String getCarNames() {
		System.out.println("자동차 이름을 입력해 주세요.");  // 2. 출력할 텍스트
		boolean passed = false;
		while (!passed) {
			initCars();
			passed = true;
		}
		return carNames;
	}

	private void initCars() {
		String input = Console.readLine();
		if (isValidCarNames(input)) {
			this.carNames = input;
		}
		throw new IllegalArgumentException();		// 3. 에러 발생 시 전달할 메시지
	}

	private boolean isValidCarNames(String string) {
		return string.matches("^[a-zA-Z][a-zA-Z0-9,]*");   // 4. 에러 확인용 정규식.
/	}

 */
