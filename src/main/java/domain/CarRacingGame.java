package domain;

import java.util.Scanner;

public class CarRacingGame {
	public static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		String carName[] = scanCarName();
		Car.carNum = carName.length;
		Car cars[] = new Car[Car.carNum];
		
		for (int i=0; i<Car.carNum; ++i) {
			cars[i] = new Car(carName[i]);
		}
		
		scanTryNumberDoGame(cars);
		printWinner(cars);
	}
	
	public static String[] scanCarName() {
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		String allCarNames = scan.nextLine();
		String carName[] = allCarNames.split(",");
		
		while (!isValidtext(carName)) {
			System.out.println("자동차의 이름은 5글자 이하여야합니다. 다시 입력하세요.");
			allCarNames = scan.nextLine();
			carName = allCarNames.split(",");
		}
		
		return carName;
	}

	public static boolean isValidtext(String[] carName) {
		for (int i=0; i<carName.length; ++i) {
			if(carName[i].length()>5) {
				return false;
			}
		}
		return true;
	}
	
	public static void scanTryNumberDoGame(Car[] cars) {
		System.out.println("시도할 회수는 몇회인가요?");
		int tryNumber = scan.nextInt();
		
		System.out.println("실행 결과");
		for (int i = 0; i < tryNumber; ++i) {
			for(int j = 0; j < Car.carNum; j++) {
				cars[j].bringRandomNumberMovePosition();
				cars[j].printResult();
			}
			System.out.println();
		}
	}
	
	public static void printWinner(Car[] cars) {
		String result = "";
		
		for (int i = 0; i < Car.carNum; ++i) {
			if (cars[i].isMaxPosition()) {
				result += cars[i].getCarName() + ", ";
			}
		}
		System.out.print(result.substring(0, result.length() -2) + "가 최종우승하였습니다!");
	}
}
