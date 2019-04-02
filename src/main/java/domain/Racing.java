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
}