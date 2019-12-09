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

	public static void main(String[] args) {
		User user = new User();
		ArrayList<Car> carList = setCarList(user);		// 차량 수만큼 인스턴스 생성하여 리스트로 집어넣기
		for (int i = 0; i < user.getTrialNum(); i++) {		// 경주할 횟수만큼 반복문 돌면서 차량 전진과 상태출력
			System.out.println("=== " + "턴 " + (i + 1) + " ===");
			for (int j = 0; j < carList.size(); j++) {
				Process.isCarProceed(carList.get(j));
				Process.printEachCarStatus(carList.get(j));
			}
		}
		System.out.println("\n[경주 결과] " 
				+ Process.printWinner(Process.findWinner(carList)) 
				+ "이(가) 최종 우승 했습니다.");
	}

	private static ArrayList<Car> setCarList(User user) {
		ArrayList<Car> carList = new ArrayList<Car>();
		for (int j = 0; j < user.getCarNames().length; j++) {
			carList.add(new Car(user.getCarNames()[j]));
		}
		return carList;
	}
}
