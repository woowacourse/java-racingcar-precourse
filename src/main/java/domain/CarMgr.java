/*
 * @CarMgr.java	1.02 	2019/04/02
 * 
 * Copyright(c)2019	HwiJin Hong.
 * All right reserved.
 * 
 * 자동차 경주 프로그램
 * 자동차에 대한 리스트를 관리하기 위한 클래스이다.
 * 관리하는 기능은 다음과 같다.
 * 1.자동차에 대한 정보들 저장한다.(중복 이름은 제거한다!)
 * 2.자동차에게 전진 또는 정지 명령을 내린다.
 * 3.자동차들의 상태 정보를 콘솔창에 출력해준다.
 * 4.1등 자동차들의 이름을 가져온다.
 */

package domain;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * 자동차의 전체 리스트를 관리해주는 클래스
 * 
 * @version 1.02 2019년 4월 2일
 * @author huisam
 */
public class CarMgr {

	private ArrayList<Car> carList;

	public CarMgr() {
		carList = new ArrayList<>();
	}

	public void addNames(String[] names) {
		HashSet<String> nameSet = new HashSet<>();
		for (String name : names) {
			if (!nameSet.contains(name)) {
				carList.add(new Car(name));
				nameSet.add(name);
			}
		}
	}

	public void goOrStop() {
		int randomNumber;
		for (Car car : carList) {
			randomNumber = makeRandom();
			if (randomNumber >= 4) {
				car.go();
			}
		}
	}

	private int makeRandom() {
		return (int) (Math.random() * 10);
	}

	public void printCarList() {
		for (Car car : carList) {
			System.out.println(car);
		}
		System.out.println();
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
