/*
 * @Racing.java		1.02 2019/04/02
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
 * @version 1.02 2019년 4월 2일
 * @author 홍휘진
 */
public class Racing {

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
			System.out.println("경주할 자동차 이름을 입력하세요.(이름은 5자 이하! 쉼표(,)기준으로 구분)");
			carNames = scanner.next();
			names = carNames.split(",");
			if (isValidUsers(names)) {
				carManager.addNames(names);
				break;
			}
			System.out.println("[입력 오류!] 5자 이하의 이름들을 반드시 쉼표(,)로 구분해주세요!");
		}
	}

	private int enterRaceTime() {
		int raceTime;
		while (true) {
			System.out.println("시도할 회수는 몇 회인가요? 0이상의 정수로 입력해주세요!");
			raceTime = scanner.nextInt();
			if (isValidTime(raceTime)) {
				return raceTime;
			}
			System.out.println("[입력 오류!] 0이상의 정수로 입력해주세요!");
		}
	}

	private void startRace(int raceTime) {
		System.out.println("실행 결과");
		for (int i = 0; i < raceTime; i++) {
			carManager.goOrStop();
			timeWaitForResult();
			carManager.printCarList();
		}
	}

	private void raceResult() {
		String winners = carManager.whoIsFirst();
		System.out.println(winners + "가 최종 우승했습니다.");
	}

	private void raceEnd() {
		scanner.close();
	}

	private boolean isValidUsers(String[] names) {
		if (names.length == 0) {
			return false;
		}
		for (String name : names) {
			if (name.length() > 5) {
				return false;
			}
		}
		return true;
	}

	private boolean isValidTime(int raceTime) {
		return (raceTime >= 0) ? true : false;
	}

	private void timeWaitForResult() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}