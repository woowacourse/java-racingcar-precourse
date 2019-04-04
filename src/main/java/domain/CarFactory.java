/*
 * CarFactory.java		2019/04/04
 * 
 * 이 프로그램은 누구나 수정 가능합니다.
 */
package domain;

import java.util.Scanner;

/**
 * Car[] Array를 생성하는 CarFactory 클래스이다.
 * 
 * @version 1.00 2019/04/04
 * @author DiceMono
 */
public class CarFactory {

	private Scanner scan = new Scanner(System.in);

	public String[] getCarNameArray() {
		String[] carNameArray;

		do {
			System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
			String carNameString = scan.nextLine();
			carNameArray = carNameString.split(",");
		} while (!isValidName(carNameArray));
		return carNameArray;
	}

	private boolean isValidName(String[] carNameArray) {
		for (String carName : carNameArray) {
			if (carName.length() == 0 || carName.length() > 5) {
				System.out.println("Error: 자동차 이름은 1자 이상, 5자이하여아 합니다.");
				return false;
			}
		}
		return true;
	}

	public Car[] makeCarArray() {
		String[] carNameArray = getCarNameArray();
		Car[] carArray = new Car[carNameArray.length];

		for (int index = 0; index < carNameArray.length; index++) {
			carArray[index] = new Car(carNameArray[index]);
		}
		return carArray;
	}
}