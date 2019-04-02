/*
 * @Racing.java		1.00 2019/04/02
 * 
 * Copyright(c)2019	HwiJin Hong.
 * All right reserved.
 * 
 * 자동차 경주 프로그램
 * 여러 자동차들이 경주하는 것을 관리하기 위한 클래스이다.
 * 사용자로부터 입력값을 받고, 입력값에 예외가 없다면
 * CarMgr 클래스를 통해 Car들을 관리한다.
 * 레이스가 진행되는 로직은 다음과 같다.
 * 1.자동차이름(사용자)들을 입력받는다.
 * 2.몇번 진행할 것인지(횟수)를 입력받는다.
 * 3.경주가 진행된다!
 * 4.레이싱 결과를 출력한다.
 * 5.경주가 끝났다!
 */

package domain;

import java.util.Scanner;

/**
 * 레이싱 정보를 가지고 있는 클래스
 * 
 * @version 1.00 2019년 4월 2일
 * @author huisam
 *
 */
public class Racing {

	private Scanner sc;

	private CarMgr carmgr;

	public Racing() {
		sc = new Scanner(System.in);
		carmgr = new CarMgr();
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
			System.out.println("경주할 자동차 이름을 입력하세요.(각각의 이름은 5자 이하! 이름은 쉼표(,)기준으로 구분)");
			carNames = sc.next();
			names = carNames.split(",");
			if (isValidUsers(names)) {
				carmgr.addNames(names);
				break;
			}
			System.out.println("----잘못된 정보를 입력하셨습니다! 5자 이하의 이름들을 반드시 쉼표(,)로 구분해주세요!----");
		}
	}

	private int enterRaceTime() {
		int raceTime;
		while (true) {
			System.out.println("시도할 회수는 몇 회인가요? 0이상의 정수로 입력해주세요!");
			raceTime = sc.nextInt();
			if (isValidTime(raceTime)) {
				return raceTime;
			}
			System.out.println("----잘못된 횟수 정보를 입력하셨습니다! 반드시 0이상의 정수로 입력해주세요!----");
		}
	}

	private void startRace(int raceTime) {
		System.out.println("실행 결과");
		for (int i = 0; i < raceTime; i++) {
			carmgr.goOrStop();
			carmgr.printCarList();
		}
	}

	private void raceResult() {
		String winners = carmgr.whoIsFirst();
		System.out.println(winners + "가 최종 우승했습니다.");
	}

	private void raceEnd() {
		sc.close();
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
}