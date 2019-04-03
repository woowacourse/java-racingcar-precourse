/*
 * @Racing.java		1.04 2019/04/03
 * 
 * Copyright(c)2019	HwiJin Hong.
 * All right reserved.
 * 
 * [ 우아한 테크코스 2주차 미션 ]
 * 자동차 경주 게임
 */

package domain;

import java.util.Scanner;

/**
 * 레이싱 정보를 가지고 있는 클래스
 * 사용자로부터 입력값을 받고, 입력값에 예외가 없다면
 * CarMgr 클래스를 통해 Car들을 관리한다.
 * 레이스가 진행되는 로직은 다음과 같다.
 * 1.자동차이름(사용자)들을 입력받는다.
 * 2.몇번 진행할 것인지(횟수)를 입력받는다.
 * 3.경주가 진행된다!
 * 4.레이싱 결과를 출력한다.
 * 5.경주가 끝났다!
 * 
 * @version 1.04 2019년 4월 3일
 * @author 홍휘진
 */
public class Racing {

	private static final int NAME_LENGTH_BOUND = 5;
	
	private static final int MIN_SIZE = 0;
	
	private static final int MIN_TIME = 0;
	
	private static final long WAIT_TIME = 1000L;
	
	private static final String CAR_NAME_READY = "경주할 자동차 이름을 입력하세요."
							+ "(이름은 5자 이하! 쉼표(,)기준으로 구분)";
	
	private static final String CAR_NAME_ERROR = "[입력 오류!] 5자 이하의 이름들을"
							+ " 반드시 쉼표(,)로 구분해주세요!";
	
	private static final String RACE_TIME_READY = "시도할 회수는 몇 회인가요?"
							+ " 0이상의 정수로 입력해주세요!";
	
	private static final String RACE_TIME_ERROR = "[입력 오류!] 0이상의 정수로 입력해주세요!";
	
	private static final String RESULT = "실행 결과";
	
	private static final String WINNER_IS = "가 최종 우승했습니다.";
	
	private Scanner scanner;

	private CarManager carManager;

	public Racing() {
		scanner = new Scanner(System.in);
		carManager = new CarManager();
	}

	public void raceBegin() {
		enterUsers();
		int raceTime = enterRaceTime();
		startRace(raceTime);
		raceResult();
		raceEnd();
	}

	private void enterUsers() {
		String carNames;
		String[] names;
		while (true) {
			System.out.println(CAR_NAME_READY);
			carNames = scanner.next();
			names = carNames.split(",");
			if (isValidUsers(names)) {
				carManager.addNames(names);
				break;
			}
			System.out.println(CAR_NAME_ERROR);
		}
	}

	private int enterRaceTime() {
		int raceTime;
		while (true) {
			System.out.println(RACE_TIME_READY);
			raceTime = scanner.nextInt();
			if (isValidTime(raceTime)) {
				return raceTime;
			}
			System.out.println(RACE_TIME_ERROR);
		}
	}

	private void startRace(int raceTime) {
		System.out.println(RESULT);
		for (int i = MIN_TIME; i < raceTime; i++) {
			carManager.goOrStop();
			timeWaitForResult();
			carManager.printCarList();
		}
	}

	private void raceResult() {
		String winners = carManager.whoIsFirst();
		System.out.println(winners + WINNER_IS);
	}

	private void raceEnd() {
		scanner.close();
	}

	private boolean isValidUsers(String[] names) {
		if (names.length == MIN_SIZE) {
			return false;
		}
		for (String name : names) {
			if (name.length() > NAME_LENGTH_BOUND) {
				return false;
			}
		}
		return true;
	}

	private boolean isValidTime(int raceTime) {
		return (raceTime >= MIN_TIME) ? true : false;
	}

	private void timeWaitForResult() {
		try {
			Thread.sleep(WAIT_TIME);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}