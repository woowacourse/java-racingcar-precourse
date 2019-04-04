package domain;

import java.util.Scanner;

import domain.InputValidator;

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
	
	public int setNumberOfAttep() {
		InputValidator validator = new InputValidator();
		String number;
		
		do {
			number = inputNumberOfAttemp().trim();
		} while (!validator.isValidNumberOfAttemp(number));
		
		return Integer.parseInt(number);
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
	
	private String inputNumberOfAttemp() {
		Scanner sc = new Scanner(System.in);
		String strNumberOfAttemp;
		
		System.out.println("시도할 회수는 몇회인가요? ");
		strNumberOfAttemp = sc.nextLine();
		
		return strNumberOfAttemp;
    } 
}
