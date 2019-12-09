package domain;

import java.util.Scanner;
import java.util.Vector;

public class RacingCar {
	
	static void showWinners(Vector <String> winners) {
		int winnersCnt;
		
		winnersCnt = winners.size();
		
		for( int i=0 ; i<winnersCnt-1; i++) {
			System.out.print(winners.get(i) + ", ");
		}
		
		System.out.println(winners.lastElement() + "가 최종 우승했습니다.");
	}
	
	static void getWinners(Vector <String> winners, Vector <Car> cars, int Max) {
		int position;
		int carCnt = cars.size();
		
		for( int i=0 ; i<carCnt ; i++) {
			Car car = cars.get(i);
			position = car.getPosition();
			
			if(Max == position) {
				winners.add(car.getName());
			}
		}
	}
	
	static int getMax(Vector <Car> cars) {
		int carCnt = cars.size();
		int Max = 0;
		int position;
		
		for( int i=0 ; i<carCnt ; i++ ) {
			Car car = cars.get(i);
			position = car.getPosition();
			
			if(Max < position) {
				Max = position;
			}
		}
		
		return Max;
	}
	
	static void moveCars(Vector <Car> cars) {
		int carCnt = cars.size();
		
		for( int i=0 ; i<carCnt ; i++ ) {
			Car car = cars.get(i);
			car.move();
			car.showName();
			car.showPosition();
			cars.setElementAt(car, i);
			System.out.println();
		}
	}
	
	static void showResult(Vector <Car> cars, int tryCnt) {
		System.out.println("실행결과");
		for( int i=0 ; i<tryCnt ; i++ ) {
			moveCars(cars);
			System.out.println();
		}
	}
	
	static int getTryCnt() {
		Scanner scanner = new Scanner(System.in);
		int input;
		
		System.out.println("시도할 회수는 몇회인가요?");
		input = scanner.nextInt();
		System.out.println();
		
		return input;
	}
	
	static void makeCars(Vector <Car> cars, String[] carNames) {
		int length;
		
		for( String name : carNames) {
			length = name.length();
			
			if(length <= 5) {
				Car car = new Car(name);
				cars.add(car);
			}
		}
	}
	
	static void getNames(Vector <Car> cars) {
		String names;
		String[] carNames;
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉽표(,)기준으로 구분)");
		names = scanner.nextLine();
		carNames = names.split(",");
		
		makeCars(cars, carNames);
	}

	public static void main(String[] args) {
		Vector <Car> cars = new Vector <Car>();
		Vector <String> winners = new Vector <String>();
		int Max;
		int tryCnt;
		
		getNames(cars);
		tryCnt = getTryCnt();
		showResult(cars, tryCnt);
		Max = getMax(cars);
		getWinners(winners, cars, Max);
		showWinners(winners);
	}

}
