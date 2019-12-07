package domain;

import java.util.Scanner;

public class RacingCar {

	public static void main(String[] args) {

		String names;
		String[] cars;
		int nameCnt;
		int carCnt = 0;
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉽표(,)기준으로 구분)");
		names = scanner.nextLine();	
		cars = names.split(",");
		nameCnt = cars.length;
		Car[] carNames = new Car[nameCnt];
		
		for( String name : cars) {
			if(name.length() <= 5) {
				carNames[carCnt++] = new Car(name);
			}
		}
	}

}
