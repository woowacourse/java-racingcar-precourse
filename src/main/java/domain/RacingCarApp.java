/**
 * @(#)RacingCarApp.java
 * 0.0.0
 * 2019/12/10
 */

package domain;

import java.util.ArrayList;

import domain.User;
import domain.Car;
import domain.Process;

/**
 * 실제 프로그램이 실행되는 클래스
 * 
 * @version 0.0.0 2019년 12월 10일
 * @author tiroring
 */
public class RacingCarApp {
	
	/** 차량 수만큼 인스턴스를 생성하여 리스트로 집어넣는다. */
	private static ArrayList<Car> setCarList(User user) {
		ArrayList<Car> carList = new ArrayList<Car>();
		for (int j = 0; j < user.getCarNames().length; j++) {
			carList.add(new Car(user.getCarNames()[j]));
		}
		return carList;
	}

	public static void main(String[] args) {
		System.out.println("=== 자동차 경주 게임 by tiroring ===");
		User user = new User();
		ArrayList<Car> carList = setCarList(user);
		for (int i = 0; i < user.getTrialNumber(); i++) {
			System.out.println("===== 턴 " + (i + 1) + " =====");
			for (int j = 0; j < carList.size(); j++) {
				Process.isCarProceed(carList.get(j));
				Process.printEachCarStatus(carList.get(j));
			}
		}
		System.out.println("\n[경주 결과] " 
				+ Process.printWinner(Process.findWinner(carList))
				+ "이(가) 최종 우승 했습니다.");
	}
}
