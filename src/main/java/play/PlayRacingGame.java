package play;

import java.util.Scanner;

import domain.Car;

public class PlayRacingGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String carNames[] = receiveCarNamesFromUser();
		Car racingCars[] = initCarObjs(carNames);
		int cntPlay = receivePlayCntFromUser();
		// 3. 게임 진행

	}
	
	private static String[] receiveCarNamesFromUser() {
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		Scanner sc = new Scanner(System.in);
		String namesFromUser = sc.nextLine();
		
		return namesFromUser.split(",");
	}
	
	private static Car[] initCarObjs(String[] carNames) {
		Car racingCars[] = new Car[carNames.length];
		for(int i = 0 ; i < racingCars.length ; i++) {
			racingCars[i] = new Car(carNames[i]);
		}
		
		return racingCars;
	}
	
	private static int receivePlayCntFromUser() {
		System.out.println("시도할 횟수는 몇회인가요?");
		Scanner sc = new Scanner(System.in);
		int playCntFromUser = sc.nextInt();
		sc.close();
		
		return playCntFromUser;
	}

}
