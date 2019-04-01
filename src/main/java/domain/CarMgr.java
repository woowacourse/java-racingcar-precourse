/*
 * @CarMgr.java	1.01 	2019/04/02
 * 
 * Copyright(c)2019	HwiJin Hong.
 * All right reserved.
 * 
 * 자동차 경주 프로그램
 * 자동차에 대한 리스트를 관리하기 위한 클래스이다.
 * 관리하는 기능은 다음과 같다.
 * 1.자동차에 대한 정보들 저장한다.
 * 2.자동차에게 전진 또는 정지 명령을 내린다.
 * 3.자동차들의 상태 정보를 콘솔창에 출력해준다.
 * 4.1등 자동차들의 이름을 가져온다.
 */

package domain;

import java.util.ArrayList;

/**
 * 자동차의 전체 리스트를 관리해주는 클래스
 * 
 * @version 1.01 2019년 4월 2일
 * @author huisam
 */
public class CarMgr {

	private ArrayList<Car> carList;
	
	public void goOrStop() {
		int randomNumber;
		for (int i = 0; i < carList.size(); i++) {
			randomNumber = makeRandom();
			if (randomNumber >= 4) {
				carList.get(i).go();
			}
		}
	}
	
	private int makeRandom() {
		return (int) (Math.random()*10);
	}
	
	public void printCarList() {
		for (Car car : carList) {
			System.out.println(car);
		}
	}
	
	public String whoIsFirst() {
		int firstPosition = findFirstPositionNumber();
		int removeIndex = 2;
		StringBuilder sb = new StringBuilder();
		for (Car car : carList) {
			if (car.getPosition() == firstPosition) {
				sb.append(car.getName()).append(", ");
			}
		}
		return sb.substring(0, sb.length() - removeIndex);
	}
	
	private int findFirstPositionNumber() {
		int firstPositionNumber = 0;
		for (Car car : carList) {
			firstPositionNumber = Math.max(car.getPosition(), firstPositionNumber);
		}
		return firstPositionNumber;
	}
}
