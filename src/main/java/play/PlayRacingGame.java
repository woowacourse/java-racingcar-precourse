/**
 * name : PlayRacingGame
 * version : 1.0
 * date : 2019.03.31
 * author : heebong
 * */

package play;

import java.util.Scanner;

import domain.Car;

public class PlayRacingGame {
	private static final int LIMITED_WORD_NUMBER = 5;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String carNames[] = receiveCarNamesFromUser();
		int cntPlay = receivePlayCntFromUser();

		Car racingCars[] = initCarObjs(carNames);
		playRacingGame(racingCars, cntPlay);
		printWinners(racingCars);

	}

	private static String[] receiveCarNamesFromUser() {
		boolean nameOverFiveWords = false;
		String namesFromUserArr[];

		do {
			System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
			Scanner sc = new Scanner(System.in);
			String namesFromUser = sc.nextLine();
			namesFromUserArr = namesFromUser.split(",");
			nameOverFiveWords = isNameOverFiveWords(namesFromUserArr);
		} while (nameOverFiveWords);

		return namesFromUserArr;
	}

	/**
	 * 입력받은 이름이 5글자 이하인지 체크. 5글자 초과일 경우 안내문 출력. 글자수 제한은 상수 LIMITED_WORD_NUMBER 로 표현
	 */
	private static boolean isNameOverFiveWords(String[] namesFromUserArr) {
		boolean nameOverFiveWords = false;

		for (String names : namesFromUserArr) {
			if (names.length() > LIMITED_WORD_NUMBER) {
				System.out.println("자동차 이름은 5글자 이하로 입력해주세요.");
				nameOverFiveWords = true;
				break;
			}
		}

		return nameOverFiveWords;
	}

	private static int receivePlayCntFromUser() {
		System.out.println("시도할 횟수는 몇회인가요?");
		Scanner sc = new Scanner(System.in);
		int playCntFromUser = sc.nextInt();
		sc.close();
		System.out.println();

		return playCntFromUser;
	}

	private static Car[] initCarObjs(String[] carNames) {
		Car racingCars[] = new Car[carNames.length];
		for (int i = 0; i < racingCars.length; i++) {
			racingCars[i] = new Car(carNames[i]);
		}

		return racingCars;
	}

	private static void playRacingGame(Car[] racingCars, int cntPlay) {
		System.out.println("실행 결과");

		for (int i = 0; i < cntPlay; i++) {
			executeCarObjsPlayRacing(racingCars);
			System.out.println();
		}
	}

	private static void executeCarObjsPlayRacing(Car[] racingCars) {
		for (Car car : racingCars) {
			car.playRacingOneTime();
		}
	}

	private static void printWinners(Car[] racingCars) {
		int winnerNum = findWinnerNum(racingCars);
		String winnersStr = findWinnersName(racingCars, winnerNum);
		System.out.println(winnersStr + "가 최종 우승했습니다.");
	}

	private static int findWinnerNum(Car[] racingCars) {
		int winnerNum = 0;
		for (Car car : racingCars) {
			winnerNum = car.getPosition() > winnerNum ? car.getPosition() : winnerNum;
		}
		return winnerNum;
	}

	private static String findWinnersName(Car[] racingCars, int winnerNum) {
		String winnersName = "";
		for (Car car : racingCars) {
			if (car.getPosition() == winnerNum) {
				winnersName += car.getName() + ",";
			}
		}
		return winnersName.substring(0, winnersName.length() - 1);
	}

}
