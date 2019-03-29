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
		playRacingGame(racingCars, cntPlay);

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
		System.out.println();
		
		return playCntFromUser;
	}
	
	private static void playRacingGame(Car[] racingCars, int cntPlay) {
		System.out.println("실행 결과");
		//01. 레이싱 횟수만큼 실행
		for(int i  = 0 ; i < cntPlay ; i++) {
			// 객체별로 게임 실행
			playCarObjsFunc(racingCars);
			System.out.println();
		}
	}
	
	private static void playCarObjsFunc(Car[] racingCars) {
		for(Car car : racingCars) {
			car.playRacingOneTime();
		}
	}

}
