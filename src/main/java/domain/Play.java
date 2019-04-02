/*
 * @Play.java		1.00 2019/04/02
 * 
 * Copyright(c)2019 HwiJin Hong.
 * All right reserved.
 * 
 * 자동차 경주 프로그램
 * 자동차 경주 대회를 실행할 클래스이다!
 * Main Class와 역할이 동일하다
 */

package domain;

/**
 * 자동차 경주 게임을 실행할 클래스
 * 
 * @version 1.00 2019년 4월 2일
 * @author huisam
 */
public class Play {
	public static void main(String[] args) {
		Racing rc = new Racing();
		rc.raceBegin();
	}
}
