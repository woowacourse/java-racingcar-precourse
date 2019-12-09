package domain;

import domain.User;
import domain.Car;
import domain.Process;
import java.util.ArrayList;

public class RacingCarApp {

	public static void main(String[] args) {
		//유저로부터 차 이름, 갯수 입력받기
		User.setValidCarNames();
		
		//차이름과 갯수만큼 인스턴스 생성하여 리스트로 집어넣기
		ArrayList<Car> carList = new ArrayList<Car>();
		for (int j = 0; j < User.getCarNames().length; j++) {
			carList.add(new Car(User.getCarNames()[j]));
		}
		
		//유저로부터 시도할 횟수 입력받기
		User.setValidTrialNum();
		
		//입력받은 횟수만큼 for-i 문 돌면서
		//for-j문 만큼 각각 자동차 순회하면서 전진여부를 판단해주고
		for (int i = 0; i < User.getTrialNum(); i++) {
			System.out.println("=====" + (i + 1) + "번째 시도" + "=====");
			for (int j = 0; j < carList.size(); j++) {
				Process.isCarProceed(carList.get(j));
				Process.printEachCarStatus(carList.get(j));
			}
		}
		
		//최고값 찾기 - findWinner메서드 담당
		//최고값 출력 - printWinner메서드 담당
		System.out.println("경주 결과 : " 
				+ Process.printWinner(Process.findWinner(carList)) 
				+ "이(가) 최종 우승 했습니다.");
	}
}
