package domain;

import java.util.Scanner;

public class CarRacingGame {
	public static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		
	}
	
	public static String[] scanCarName() {
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		String allCarNames = scan.nextLine();
		String carName[] = allCarNames.split(",");
		
		return carName;
	}

}
