/*
 * @Play.java		1.00 2019/04/02
 * 
 * Copyright(c)2019 HwiJin Hong.
 * All right reserved.
 * 
 * [ 우아한 테크코스 2주차 미션 ]
 * 자동차 경주 프로그램
 */

package domain;

/**
 * 자동차 경주 게임을 실행할 클래스
 * 
 * @version 1.00 2019년 4월 2일
 * @author 홍휘진
 */
public class Play {
	public static void main(String[] args) {
		Racing rc = new Racing();
		rc.raceBegin();
	}
}
