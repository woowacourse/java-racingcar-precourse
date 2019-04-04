package domain;

import java.util.Scanner;

public class CarFactory {
	
	private Scanner scan = new Scanner(System.in);
	private String[] carNamesArray;
	
	public CarFactory() {
		do{
			System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
			String carNames = scan.nextLine();
			carNamesArray = carNames.split(",");
		} while(!isValidName(carNamesArray));
	}
	
	public Car[] makeCars() {
		Car[] cars = new Car[carNamesArray.length];
		
		for(int index = 0; index<carNamesArray.length; index++) {
			cars[index] = new Car(carNamesArray[index]);
		}
		return cars;
	}
	
	private boolean isValidName(String[] carNamesArray) {
		for(String carName : carNamesArray) {
			if(carName.length() == 0 || carName.length() > 5) {
				System.out.println("Error: 자동차 이름은 5자 이하여아 합니다.");
				return false;
			}
		}
		return true;
	}
}
