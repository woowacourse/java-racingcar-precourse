package play;

import java.util.Scanner;

import domain.Car;

public class PlayRacingGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1. 사용자로부터 car 이름 받기
		String carNames[] = receiveCarNamesFromUser();
		// 2. car 객체 생성
		Car racingCars[] = initCarObjs(carNames);
		for(Car c : racingCars) {
			System.out.println("car : " + c.getName());
		}
		// 3. 게임 진행

	}
	
	private static String[] receiveCarNamesFromUser() {
		Scanner sc = new Scanner(System.in);
		String inputNames = sc.next();
		sc.close();
		
		return inputNames.split(",");
	}
	
	private static Car[] initCarObjs(String[] carNames) {
		Car racingCars[] = new Car[carNames.length];
		for(int i = 0 ; i < racingCars.length ; i++) {
			racingCars[i] = new Car(carNames[i]);
		}
		
		return racingCars;
	}

}
