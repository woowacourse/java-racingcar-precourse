/*
 * @CarMgr.java		1.02 2019/04/02
 * 
 * Copyright(c)2019	HwiJin Hong.
 * All right reserved.
 * 
 * [ 우아한 테크코스 2주차 미션 ]
 * 자동차 경주 프로그램
 */

package domain;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * 자동차의 전체 리스트를 관리해주는 클래스
 * 관리하는 기능은 다음과 같다.
 * 1.자동차에 대한 정보들 저장한다.(중복 이름은 제거한다!)
 * 2.자동차에게 전진 또는 정지 명령을 내린다.
 * 3.자동차들의 상태 정보를 콘솔창에 출력해준다.
 * 4.1등 자동차들의 이름을 가져온다.
 * 
 * @version 1.02 2019년 4월 2일
 * @author 홍휘진
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
		StringBuilder firstCars = new StringBuilder();
		for (Car car : carList) {
			if (car.getPosition() == firstPosition) {
				firstCars.append(car.getName()).append(", ");
			}
		}
		return firstCars.substring(0, firstCars.length() - removeIndex);
	}

	private int findFirstPositionNumber() {
		int firstPositionNumber = 0;
		for (Car car : carList) {
			firstPositionNumber = Math.max(car.getPosition(), firstPositionNumber);
		}
		return firstPositionNumber;
	}
}
