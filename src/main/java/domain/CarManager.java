/*
 * @CarManager.java	1.11 2019/04/03
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
 * @version 1.11 2019년 4월 3일
 * @author 홍휘진
 */
public class CarManager {

	private static final int RANDOM_BOUND = 10;
	
	private static final int STOP_BOUND = 3;
	
	private static final int REMOVE_INDEX = 2;
	
	private static final int START_INDEX = 0;
	
	private static final int MIN_POSITION = 0;
	
	private ArrayList<Car> carList;

	public CarManager() {
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
			if (randomNumber > STOP_BOUND) {
				car.go();
			}
		}
	}

	private int makeRandom() {
		return (int) (Math.random() * RANDOM_BOUND);
	}

	public void printCarList() {
		for (Car car : carList) {
			System.out.println(car);
		}
		System.out.println();
	}

	public String whoIsFirst() {
		int firstPosition = findFirstPositionNumber();
		StringBuilder firstCars = new StringBuilder();
		for (Car car : carList) {
			if (car.getPosition() == firstPosition) {
				firstCars.append(car.getName()).append(", ");
			}
		}
		return firstCars.substring(START_INDEX, firstCars.length() - REMOVE_INDEX);
	}

	private int findFirstPositionNumber() {
		int firstPositionNumber = MIN_POSITION;
		for (Car car : carList) {
			firstPositionNumber = Math.max(car.getPosition(), firstPositionNumber);
		}
		return firstPositionNumber;
	}
}
