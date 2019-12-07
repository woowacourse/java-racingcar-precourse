package domain;

import java.util.Scanner;

public class RacingCar {

	public static void main(String[] args) {

		String names;
		String[] cars;
		int nameCnt;
		int carCnt = 0;
		int tryCnt;
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
		
		System.out.println("시도할 회수는 몇회인가요?");
		tryCnt = scanner.nextInt();
		System.out.println();
		
		System.out.println("실행결과");
		for( int i=0 ; i<tryCnt ; i++ ) {
			for( int j=0 ; j<carCnt ; j++ ) {
				carNames[j].move();
				carNames[j].showPosition();
			}
			System.out.println();
		}
	}

}
