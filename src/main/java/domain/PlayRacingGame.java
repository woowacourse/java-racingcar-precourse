/**
 * name : PlayRacingGame
 * version : 1.0
 * date : 2019.03.31
 * author : heebong
 * */

package domain;

import java.util.InputMismatchException;
import java.util.Scanner;

import domain.Car;

public class PlayRacingGame {
	private  final int LIMITED_WORD_NUMBER = 5;

	public void play() {
		// TODO Auto-generated method stub
		String carNames[] = receiveCarNamesFromUser();
		int cntPlay = receivePlayCntFromUser();

		Car racingCars[] = initCarObjs(carNames);
		playRacingGame(racingCars, cntPlay);
		printWinners(racingCars);

	}

	private String[] receiveCarNamesFromUser() {
		boolean validationProblem = false;
		String namesFromUserArr[];

		do {
			System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
			Scanner sc = new Scanner(System.in);
			String namesFromUser = sc.nextLine();
			namesFromUserArr = namesFromUser.split(",");
			validationProblem = hasValidationProblem(namesFromUserArr);
		} while (validationProblem);

		return namesFromUserArr;
	}

	/**
	 * 자동차 이름 값 체크.
	 * 1) 입력받은 이름이 5글자 이하인지 체크. 5글자 초과일 경우 안내문 출력. 글자수 제한은 상수 LIMITED_WORD_NUMBER 로 표현
	 * 2) 자동차 이름이 0개면 다시 입력
	 */
	private boolean hasValidationProblem(String[] namesFromUserArr) {
		boolean validationProblem = false;

		for (String names : namesFromUserArr) {
			if (names.length() > LIMITED_WORD_NUMBER) {
				System.out.println("자동차 이름은 5글자 이하로 입력해주세요.");
				validationProblem = true;
				break;
			}
			if(names.length() <= 0) {
				System.out.println("자동차 이름은 한개 이상 입력해주세요.");
				validationProblem = true;
				break;
			}
		}

		return validationProblem;
	}
	
	/**
	 * 게임 횟수 값 체크
	 * 1) 0 미만의 수가 들어오면 경고문 출력 후 다시 입력.
	 * */
	private boolean hasValidationProblem(int playCntFromUser) {
		boolean validationProblem = false;
		
		if(playCntFromUser <= 0) {
			System.out.println("0 이상의 숫자를 입력하세요");
			validationProblem = true;
		}
		
		return validationProblem;
	}

	private int receivePlayCntFromUser() {
		boolean validationProblem = false;
		int playCntFromUser = 0;
		
		do {
			System.out.println("시도할 횟수는 몇회인가요?");
			Scanner sc = new Scanner(System.in);
			
			/* 문자를 입력했을 때 경고문 출력 */
			try {
				playCntFromUser = sc.nextInt();
				validationProblem = hasValidationProblem(playCntFromUser);
			}catch(InputMismatchException e) {
				System.out.println("정수를 입력해주세요");
				validationProblem = true;
			}
			
		} while(validationProblem);

		System.out.println();

		return playCntFromUser;
	}

	private Car[] initCarObjs(String[] carNames) {
		Car racingCars[] = new Car[carNames.length];
		for (int i = 0; i < racingCars.length; i++) {
			racingCars[i] = new Car(carNames[i]);
		}

		return racingCars;
	}

	private void playRacingGame(Car[] racingCars, int cntPlay) {
		System.out.println("실행 결과");

		for (int i = 0; i < cntPlay; i++) {
			executeCarObjsPlayRacing(racingCars);
			System.out.println();
		}
	}

	private void executeCarObjsPlayRacing(Car[] racingCars) {
		for (Car car : racingCars) {
			car.playRacingOneTime();
		}
	}

	private void printWinners(Car[] racingCars) {
		int winnerNum = findWinnerNum(racingCars);
		String winnersStr = findWinnersName(racingCars, winnerNum);
		System.out.println(winnersStr + "가 최종 우승했습니다.");
	}

	private int findWinnerNum(Car[] racingCars) {
		int winnerNum = 0;
		for (Car car : racingCars) {
			winnerNum = car.getPosition() > winnerNum ? car.getPosition() : winnerNum;
		}
		return winnerNum;
	}

	private String findWinnersName(Car[] racingCars, int winnerNum) {
		String winnersName = "";
		for (Car car : racingCars) {
			if (car.getPosition() == winnerNum) {
				winnersName += car.getName() + ",";
			}
		}
		return winnersName.substring(0, winnersName.length() - 1);
	}

}
