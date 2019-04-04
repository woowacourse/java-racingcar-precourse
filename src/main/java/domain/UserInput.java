package domain;

import java.util.Scanner;

public class UserInput {
	private String carNames;
	private String[] arrCarNames;
	
	public String[] setCarNames() {
		InputValidator validator = new InputValidator();
		
		do {
			inputCarNames();
			splitCarNames();
		} while (!validator.isValidCarNames(arrCarNames));
		
		return arrCarNames;
	}
	
	private void inputCarNames() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		carNames = sc.nextLine();
	}
	
	private void splitCarNames() {
		arrCarNames = carNames.split(",");
		
		for (int i = 0; i < arrCarNames.length; i++) {
			arrCarNames[i] = arrCarNames[i].trim();
		}
	}
}
