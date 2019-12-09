/**
 * @(#)Process.java
 * 0.0.0
 * 2019/12/10
 */

package domain;

import java.util.ArrayList;

/**
 * 내부 연산 및 결과 출력기능을 위한 클래스
 * 
 * @version 0.0.0 2019년 12월 10일
 * @author tiroring
 */
public class Process {
	private static final int CONDITION = 3;
	
	public static void isCarProceed(Car currentCar) {
		if ((int) Math.floor(Math.random() * 10) > CONDITION) {
			currentCar.addPosition();
		}
	}
	
	public static void printEachCarStatus(Car currentCar) {
		System.out.print(currentCar.getName() + " : ");
		for (int i = 0; i < currentCar.getPosition(); i++) {
			System.out.print('-');
		}
		System.out.print("\n");
	}
	
	public static ArrayList<Car> findWinner(ArrayList<Car> car) {
		ArrayList<Car> winnersCarList = new ArrayList<Car>();
		int nowMaxPosition = 0;
		for (int i = 0; i < car.size(); i++) {
			if (car.get(i).getPosition() == nowMaxPosition) {
				winnersCarList.add(car.get(i));
			}
			if (car.get(i).getPosition() > nowMaxPosition) {
				winnersCarList = new ArrayList<Car>();
				winnersCarList.add(car.get(i));
				nowMaxPosition = car.get(i).getPosition();
			}
		}
		return winnersCarList;
	}
	
	public static String printWinner(ArrayList<Car> winners) {
		ArrayList<String> winnersName = new ArrayList<String>();
		for (int i = 0; i < winners.size(); i++) {
			winnersName.add(winners.get(i).getName());
		}
		return String.join(", ", winnersName);
	}
}
